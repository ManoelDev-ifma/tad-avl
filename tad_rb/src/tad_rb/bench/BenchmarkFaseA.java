package tad_rb.bench;

import java.util.Random;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import tad_rb.avl.ArvoreAVL;
import tad_rb.rb.RedBlackTree;

public class BenchmarkFaseA {
    public static void main(String[] args) {
        int n = 100_000;
        if (args.length > 0) {
            try { n = Integer.parseInt(args[0]); } catch (Exception e) { }
        }

        System.out.println("Benchmark Fase A - Escrita Intensiva");
        System.out.println("Número de inserções: " + n);

        Random rnd = new Random(42);
        HashSet<Integer> set = new HashSet<>(n);
        List<Integer> values = new ArrayList<>(n);
        while (set.size() < n) {
            int v = rnd.nextInt(Integer.MAX_VALUE);
            if (set.add(v)) values.add(v);
        }

        ArvoreAVL<Integer> avl = new ArvoreAVL<>();
        long t0 = System.nanoTime();
        for (int v : values) avl.inserir(v);
        long t1 = System.nanoTime();
        long avlTimeMs = (t1 - t0) / 1_000_000;
        long avlLeft = avl.getRotacoesEsquerda();
        long avlRight = avl.getRotacoesDireita();

        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        rbt.setEnableIntegrityChecks(false);
        long t2 = System.nanoTime();
        for (int v : values) rbt.insert(v);
        long t3 = System.nanoTime();
        long rbtTimeMs = (t3 - t2) / 1_000_000;
        long rbtLeft = rbt.leftRotations;
        long rbtRight = rbt.rightRotations;

        System.out.println("\nResultados:");
        System.out.println("AVL: tempo=" + avlTimeMs + " ms, rot-esq=" + avlLeft + ", rot-dir=" + avlRight);
        System.out.println("Rubro-Negra: tempo=" + rbtTimeMs + " ms, rot-esq=" + rbtLeft + ", rot-dir=" + rbtRight);

        double speedup = (double) avlTimeMs / Math.max(1, rbtTimeMs);
        System.out.println(String.format("\nRelação de tempo (AVL / RB): %.2f", speedup));
    }
}
