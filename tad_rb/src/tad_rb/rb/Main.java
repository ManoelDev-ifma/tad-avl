package tad_rb.rb;

public class Main {
    public static void main(String[] args) {
        RedBlackTree<Integer> tree = new RedBlackTree<>();

        int[] toInsert = {20, 15, 25, 10, 18, 22, 30, 5, 12, 17, 19};
        System.out.println("Inserindo: ");
        for (int v : toInsert) {
            System.out.print(v + " ");
            tree.insert(v);
        }
        System.out.println("\n\nÁrvore após inserções:");
        tree.printInOrder();
        System.out.println();
        System.out.println("Rotações à esquerda: " + tree.leftRotations + ", à direita: " + tree.rightRotations);

        System.out.println("\nRemovendo 15 e 20");
        tree.remove(15);
        tree.remove(20);
        System.out.println("\nÁrvore após remoções:");
        tree.printInOrder();
        System.out.println();
        System.out.println("Rotações à esquerda: " + tree.leftRotations + ", à direita: " + tree.rightRotations);
    }
}
