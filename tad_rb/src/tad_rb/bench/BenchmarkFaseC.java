package tad_rb.bench;

import java.util.Random;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import tad_rb.avl.ArvoreAVL;
import tad_rb.rb.RedBlackTree;

public class BenchmarkFaseC {
    public static void main(String[] args) {
        int n = 100_000;
        int removals = -1; // if -1 -> 10% of n
        int reps = 1; // unused here
        if (args.length > 0) try { n = Integer.parseInt(args[0]); } catch (Exception e) {}
        if (args.length > 1) try { removals = Integer.parseInt(args[1]); } catch (Exception e) {}

        if (removals < 0) removals = n / 10;

        System.out.println("Benchmark Fase C - Limpeza (remoção de 10%)");
        System.out.println("N=" + n + ", removidos=" + removals);

        Random rnd = new Random(321);
        HashSet<Integer> set = new HashSet<>(n);
        List<Integer> values = new ArrayList<>(n);
        while (set.size() < n) {
            int v = rnd.nextInt(Integer.MAX_VALUE);
            if (set.add(v)) values.add(v);
        }

        // preencher AVL
        ArvoreAVL<Integer> avl = new ArvoreAVL<>();
        for (int v : values) avl.inserir(v);
        // preencher RB
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        rbt.setEnableIntegrityChecks(false);
        for (int v : values) rbt.insert(v);

        // escolher chaves a remover (removals únicas)
        List<Integer> toRemove = new ArrayList<>(removals);
        HashSet<Integer> used = new HashSet<>();
        while (toRemove.size() < removals) {
            int v = values.get(rnd.nextInt(values.size()));
            if (used.add(v)) toRemove.add(v);
        }

        long t0 = System.nanoTime();
        for (int x : toRemove) avl.remover(x);
        long t1 = System.nanoTime();
        long avlRemMs = (t1 - t0) / 1_000_000;
        long avlRe = avl.getRotacoesEsquerda();
        long avlRd = avl.getRotacoesDireita();
        int avlAlt = avl.altura();

        long t2 = System.nanoTime();
        for (int x : toRemove) rbt.remove(x);
        long t3 = System.nanoTime();
        long rbtRemMs = (t3 - t2) / 1_000_000;
        long rbtRe = rbt.leftRotations;
        long rbtRd = rbt.rightRotations;
        int rbtAlt = rbt.altura();

        System.out.println("\nResultados Fase C:");
        System.out.println("AVL: tempo_remocao_ms=" + avlRemMs + ", rot-esq=" + avlRe + ", rot-dir=" + avlRd + ", altura=" + avlAlt);
        System.out.println("Rubro-Negra: tempo_remocao_ms=" + rbtRemMs + ", rot-esq=" + rbtRe + ", rot-dir=" + rbtRd + ", altura=" + rbtAlt);
    }
}
