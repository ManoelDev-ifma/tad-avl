package tad_rb.avl;

/**
 * Nó da Árvore AVL
 */
public class AVLNode<T extends Comparable<T>> {
    T dado;
    AVLNode<T> esquerda;
    AVLNode<T> direita;
    int altura;

    public AVLNode(T dado) {
        this.dado = dado;
        this.altura = 1;
    }
}
