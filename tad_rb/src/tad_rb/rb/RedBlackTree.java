package tad_rb.rb;

import java.util.Objects;

/**
 * Árvore rubro-negra genérica com sentinel
 */
public class RedBlackTree<T extends Comparable<T>> {

    public enum Color { RED, BLACK }

    public final Node<T> Nil; // sentinel único
    public Node<T> root;

    public long leftRotations = 0;
    public long rightRotations = 0;
    private boolean enableIntegrityChecks = true;

    public void setEnableIntegrityChecks(boolean v) { this.enableIntegrityChecks = v; }

    public RedBlackTree() {
        Nil = new Node<>(null);
        Nil.color = Color.BLACK;
        Nil.left = Nil.right = Nil.parent = Nil;
        root = Nil;
    }

    public static class Node<T> {
        public Color color;
        public T key;
        public Node<T> left, right, parent;

        public Node(T key) { this.key = key; this.color = Color.RED; }
        public String toString() { return String.format("%s(%s)", key, color == Color.RED ? "R" : "B"); }
    }

    public Node<T> search(T key) {
        Node<T> x = root;
        while (x != Nil && !Objects.equals(x.key, key)) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left; else x = x.right;
        }
        return x;
    }

    private Node<T> minimum(Node<T> x) { while (x.left != Nil) x = x.left; return x; }

    private void transplant(Node<T> u, Node<T> v) {
        if (u.parent == Nil) root = v; else if (u == u.parent.left) u.parent.left = v; else u.parent.right = v; v.parent = u.parent;
    }

    private void leftRotate(Node<T> x) {
        Node<T> y = x.right; x.right = y.left; if (y.left != Nil) y.left.parent = x; y.parent = x.parent;
        if (x.parent == Nil) root = y; else if (x == x.parent.left) x.parent.left = y; else x.parent.right = y;
        y.left = x; x.parent = y; leftRotations++;
    }

    private void rightRotate(Node<T> x) {
        Node<T> y = x.left; x.left = y.right; if (y.right != Nil) y.right.parent = x; y.parent = x.parent;
        if (x.parent == Nil) root = y; else if (x == x.parent.right) x.parent.right = y; else x.parent.left = y;
        y.right = x; x.parent = y; rightRotations++;
    }

    public void insert(T key) {
        Node<T> z = new Node<>(key); Node<T> y = Nil; Node<T> x = root;
        while (x != Nil) { y = x; if (z.key.compareTo(x.key) < 0) x = x.left; else x = x.right; }
        z.parent = y; if (y == Nil) root = z; else if (z.key.compareTo(y.key) < 0) y.left = z; else y.right = z;
        z.left = Nil; z.right = Nil; z.color = Color.RED; insertFixup(z);
        if (enableIntegrityChecks && !verifyIntegrity()) throw new IllegalStateException("Invariante RB violada após inserção de " + key);
    }

    private void insertFixup(Node<T> z) {
        while (z.parent.color == Color.RED) {
            if (z.parent == z.parent.parent.left) {
                Node<T> y = z.parent.parent.right;
                if (y.color == Color.RED) { z.parent.color = Color.BLACK; y.color = Color.BLACK; z.parent.parent.color = Color.RED; z = z.parent.parent; }
                else { if (z == z.parent.right) { z = z.parent; leftRotate(z); } z.parent.color = Color.BLACK; z.parent.parent.color = Color.RED; rightRotate(z.parent.parent); }
            } else {
                Node<T> y = z.parent.parent.left;
                if (y.color == Color.RED) { z.parent.color = Color.BLACK; y.color = Color.BLACK; z.parent.parent.color = Color.RED; z = z.parent.parent; }
                else { if (z == z.parent.left) { z = z.parent; rightRotate(z); } z.parent.color = Color.BLACK; z.parent.parent.color = Color.RED; leftRotate(z.parent.parent); }
            }
        }
        root.color = Color.BLACK;
    }

    public boolean remove(T key) {
        Node<T> z = search(key); if (z == Nil) return false; Node<T> y = z; Color yOriginalColor = y.color; Node<T> x;
        if (z.left == Nil) { x = z.right; transplant(z, z.right); }
        else if (z.right == Nil) { x = z.left; transplant(z, z.left); }
        else { y = minimum(z.right); yOriginalColor = y.color; x = y.right; if (y.parent == z) x.parent = y; else { transplant(y, y.right); y.right = z.right; y.right.parent = y; } transplant(z, y); y.left = z.left; y.left.parent = y; y.color = z.color; }
        if (yOriginalColor == Color.BLACK) removeFixup(x);
        if (enableIntegrityChecks && !verifyIntegrity()) throw new IllegalStateException("Invariante RB violada após remoção de " + key);
        return true;
    }

    public boolean verifyIntegrity() {
        if (Nil.color != Color.BLACK) { System.err.println("Falha: Nil não é preto"); return false; }
        if (root != Nil && root.color != Color.BLACK) { System.err.println("Falha: raiz não é preta"); return false; }
        StringBuilder err = new StringBuilder(); int bh = verifyNode(root, err); if (bh == -1) { System.err.println("Falha: " + err.toString()); return false; } return true;
    }

    private int verifyNode(Node<T> node, StringBuilder err) {
        if (node == Nil) return 1;
        if (node.color != Color.RED && node.color != Color.BLACK) { err.append("Nó " + node.key + " com cor inválida\n"); return -1; }
        if (node.color == Color.RED) { if (node.left.color == Color.RED || node.right.color == Color.RED) { err.append("Nó vermelho " + node.key + " tem filho vermelho\n"); return -1; } }
        int left = verifyNode(node.left, err); if (left == -1) return -1; int right = verifyNode(node.right, err); if (right == -1) return -1; if (left != right) { err.append("Altura preta inconsistente em " + node.key + ": esquerdo=" + left + " direito=" + right + "\n"); return -1; }
        return left + (node.color == Color.BLACK ? 1 : 0);
    }

    private void removeFixup(Node<T> x) {
        while (x != root && x.color == Color.BLACK) {
            if (x == x.parent.left) {
                Node<T> w = x.parent.right;
                if (w.color == Color.RED) { w.color = Color.BLACK; x.parent.color = Color.RED; leftRotate(x.parent); w = x.parent.right; }
                if (w.left.color == Color.BLACK && w.right.color == Color.BLACK) { w.color = Color.RED; x = x.parent; }
                else { if (w.right.color == Color.BLACK) { w.left.color = Color.BLACK; w.color = Color.RED; rightRotate(w); w = x.parent.right; } w.color = x.parent.color; x.parent.color = Color.BLACK; w.right.color = Color.BLACK; leftRotate(x.parent); x = root; }
            } else {
                Node<T> w = x.parent.left;
                if (w.color == Color.RED) { w.color = Color.BLACK; x.parent.color = Color.RED; rightRotate(x.parent); w = x.parent.left; }
                if (w.right.color == Color.BLACK && w.left.color == Color.BLACK) { w.color = Color.RED; x = x.parent; }
                else { if (w.left.color == Color.BLACK) { w.right.color = Color.BLACK; w.color = Color.RED; leftRotate(w); w = x.parent.left; } w.color = x.parent.color; x.parent.color = Color.BLACK; w.left.color = Color.BLACK; rightRotate(x.parent); x = root; }
            }
        }
        x.color = Color.BLACK;
    }

    public void printInOrder() { printInOrder(root, "", true); }
    private void printInOrder(Node<T> node, String prefix, boolean isTail) { if (node == Nil) return; if (node.right != Nil) printInOrder(node.right, prefix + (isTail ? "    " : "│   "), false); System.out.println(prefix + (isTail ? "└── " : "┌── ") + node); if (node.left != Nil) printInOrder(node.left, prefix + (isTail ? "    " : "│   "), true); }

    // Retorna a altura (número de níveis) da árvore
    public int altura() {
        return alturaRec(root);
    }

    private int alturaRec(Node<T> node) {
        if (node == Nil) return 0;
        return 1 + Math.max(alturaRec(node.left), alturaRec(node.right));
    }

}
