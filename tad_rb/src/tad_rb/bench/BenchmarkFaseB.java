package tad_rb.bench;

import java.util.Random;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import tad_rb.avl.ArvoreAVL;
import tad_rb.rb.RedBlackTree;

public class BenchmarkFaseB {
    public static void main(String[] args) {
        int n = 100_000; // número de nós
        int m = 100_000; // número de buscas
        if (args.length > 0) try { n = Integer.parseInt(args[0]); } catch (Exception e) {}
        if (args.length > 1) try { m = Integer.parseInt(args[1]); } catch (Exception e) {}

        System.out.println("Benchmark Fase B - Leitura Intensiva");
        System.out.println("N (nós): " + n + ", M (buscas): " + m);

        Random rnd = new Random(123);
        HashSet<Integer> set = new HashSet<>(n);
        List<Integer> values = new ArrayList<>(n);
        while (set.size() < n) {
            int v = rnd.nextInt(Integer.MAX_VALUE);
            if (set.add(v)) values.add(v);
        }

        // preencher estruturas
        ArvoreAVL<Integer> avl = new ArvoreAVL<>();
        for (int v : values) avl.inserir(v);
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        rbt.setEnableIntegrityChecks(false);
        for (int v : values) rbt.insert(v);

        // medir buscas: escolhe M chaves existentes aleatórias e busca
        List<Integer> queries = new ArrayList<>(m);
        for (int i = 0; i < m; i++) queries.add(values.get(rnd.nextInt(values.size())));

        long t0 = System.nanoTime();
        for (int q : queries) avl.buscar(q);
        long t1 = System.nanoTime();
        long avlTimeMs = (t1 - t0) / 1_000_000;

        long t2 = System.nanoTime();
        for (int q : queries) rbt.search(q);
        long t3 = System.nanoTime();
        long rbtTimeMs = (t3 - t2) / 1_000_000;

        int avlAltura = avl.altura();
        int rbtAltura = rbt.altura();

        System.out.println("\nResultados Fase B:");
        System.out.println("AVL: altura=" + avlAltura + ", tempo_busca_total=" + avlTimeMs + " ms");
        System.out.println("Rubro-Negra: altura=" + rbtAltura + ", tempo_busca_total=" + rbtTimeMs + " ms");
    }
}
