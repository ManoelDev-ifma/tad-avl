/**
 * Testes da Árvore AVL
 */
public class TesteArvoreAVL {

    public static void main(String[] args) {
        System.out.println("=== TESTES DA ÁRVORE AVL ===\n");

        // Teste 1: Inserções e visualização
        System.out.println("--- Teste 1: Inserções Básicas ---");
        ArvoreAVL<Integer> arvore = new ArvoreAVL<>();
        
        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(30);
        arvore.inserir(40);
        arvore.inserir(50);
        arvore.inserir(25);

        System.out.println("Árvore:");
        arvore.exibir();
        System.out.println("Tamanho: " + arvore.tamanho());
        System.out.println("Altura: " + arvore.altura());
        arvore.emOrdem();
        System.out.println();

        // Teste 2: Busca
        System.out.println("--- Teste 2: Busca ---");
        System.out.println("Buscar 25: " + arvore.buscar(25));
        System.out.println("Buscar 100: " + arvore.buscar(100));
        System.out.println("Mínimo: " + arvore.minimo());
        System.out.println("Máximo: " + arvore.maximo());
        System.out.println();

        // Teste 3: Remoção
        System.out.println("--- Teste 3: Remoção ---");
        System.out.println("Removendo 20...");
        arvore.remover(20);
        arvore.exibir();
        arvore.emOrdem();
        System.out.println();

        // Teste 4: Rotação Direita (LL)
        System.out.println("--- Teste 4: Rotação Direita (LL) ---");
        ArvoreAVL<Integer> arvore2 = new ArvoreAVL<>();
        arvore2.inserir(30);
        arvore2.inserir(20);
        arvore2.inserir(10);
        arvore2.exibir();
        arvore2.emOrdem();
        System.out.println();

        // Teste 5: Rotação Esquerda (RR)
        System.out.println("--- Teste 5: Rotação Esquerda (RR) ---");
        ArvoreAVL<Integer> arvore3 = new ArvoreAVL<>();
        arvore3.inserir(10);
        arvore3.inserir(20);
        arvore3.inserir(30);
        arvore3.exibir();
        arvore3.emOrdem();
        System.out.println();

        // Teste 6: Rotação Dupla Esquerda-Direita (LR)
        System.out.println("--- Teste 6: Rotação Dupla Esquerda-Direita (LR) ---");
        ArvoreAVL<Integer> arvore4 = new ArvoreAVL<>();
        arvore4.inserir(30);
        arvore4.inserir(10);
        arvore4.inserir(20);
        arvore4.exibir();
        arvore4.emOrdem();
        System.out.println();

        // Teste 7: Rotação Dupla Direita-Esquerda (RL)
        System.out.println("--- Teste 7: Rotação Dupla Direita-Esquerda (RL) ---");
        ArvoreAVL<Integer> arvore5 = new ArvoreAVL<>();
        arvore5.inserir(10);
        arvore5.inserir(30);
        arvore5.inserir(20);
        arvore5.exibir();
        arvore5.emOrdem();
        System.out.println();

        // Teste 8: Percursos
        System.out.println("--- Teste 8: Percursos ---");
        ArvoreAVL<Integer> arvore6 = new ArvoreAVL<>();
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int val : valores) {
            arvore6.inserir(val);
        }
        arvore6.exibir();
        arvore6.emOrdem();
        arvore6.preOrdem();
        arvore6.posOrdem();
        System.out.println();

        // Teste 9: Strings
        System.out.println("--- Teste 9: Árvore com Strings ---");
        ArvoreAVL<String> arvoreStr = new ArvoreAVL<>();
        arvoreStr.inserir("Java");
        arvoreStr.inserir("Python");
        arvoreStr.inserir("C++");
        arvoreStr.inserir("JavaScript");
        arvoreStr.inserir("Go");
        arvoreStr.exibir();
        arvoreStr.emOrdem();
        System.out.println("Buscar 'Python': " + arvoreStr.buscar("Python"));
        System.out.println();

        // Teste 10: Inserção Sequencial
        System.out.println("--- Teste 10: Inserção Sequencial (1 a 10) ---");
        ArvoreAVL<Integer> arvore7 = new ArvoreAVL<>();
        for (int i = 1; i <= 10; i++) {
            arvore7.inserir(i);
        }
        arvore7.exibir();
        System.out.println("Altura: " + arvore7.altura());
        arvore7.emOrdem();

        System.out.println("\n=== TODOS OS TESTES CONCLUÍDOS ===");
    }
}
