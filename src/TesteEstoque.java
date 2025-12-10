public class TesteEstoque {
    public static void main(String[] args) {
        EstoqueOficina estoque = new EstoqueOficina();
        
        System.out.println("╔═══════════════════════════════════╗");
        System.out.println("║  TESTE DO SISTEMA DE ESTOQUE      ║");
        System.out.println("╚═══════════════════════════════════╝\n");
        
        System.out.println(">>> Carregando peças...\n");
        estoque.adicionarPeca(1001, "Óleo 5W30", 25, 35.50);
        estoque.adicionarPeca(1002, "Filtro de ar", 40, 28.00);
        estoque.adicionarPeca(1003, "Corrente", 8, 280.00);
        estoque.adicionarPeca(1004, "Pastilha de freio", 15, 89.90);
        estoque.adicionarPeca(1005, "Vela", 2, 12.50);
        estoque.adicionarPeca(1006, "Bateria", 5, 450.00);
        
        estoque.exibirEstoque();
        
        System.out.println(">>> Buscando peça 1003...");
        Peca p = estoque.buscarPeca(1003);
        if (p != null) System.out.println("Encontrada: " + p);
        
        System.out.println("\n>>> Atualizando quantidade de 1005...");
        estoque.atualizarQuantidade(1005, 20);
        System.out.println("Nova quantidade: " + estoque.buscarPeca(1005).getQuantidade());
        
        System.out.println("\n>>> Atualizando preço de 1002...");
        estoque.atualizarPreco(1002, 32.00);
        System.out.println("Novo preço: R$ " + estoque.buscarPeca(1002).getPreco());
        
        System.out.println("\n>>> Removendo peça 1006...");
        estoque.removerPeca(1006);
        System.out.println("Peça removida. Total: " + estoque.totalPecas());
        
        System.out.println("\n>>> Estoque atualizado:");
        estoque.exibirEstoque();
        
        estoque.listarEstoqueBaixo(10);
        
        System.out.printf(">>> Valor total: R$ %.2f\n", estoque.calcularValorEstoque());
        System.out.println(">>> Total de tipos: " + estoque.totalPecas());
    }
}
