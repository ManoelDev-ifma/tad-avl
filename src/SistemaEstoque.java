import java.util.Scanner;

public class SistemaEstoque {
    private EstoqueOficina estoque;
    private Scanner scanner;

    public SistemaEstoque() {
        this.estoque = new EstoqueOficina();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        carregarDadosTeste();
        
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            if (!procesarOpcao(opcao)) break;
        }
        
        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║   SISTEMA DE ESTOQUE - OFICINA  ║");
        System.out.println("╚════════════════════════════════╝");
        System.out.println("1. Cadastrar peça");
        System.out.println("2. Buscar peça");
        System.out.println("3. Atualizar quantidade");
        System.out.println("4. Atualizar preço");
        System.out.println("5. Remover peça");
        System.out.println("6. Exibir estoque");
        System.out.println("7. Listar estoque baixo");
        System.out.println("8. Valor total do estoque");
        System.out.println("9. Total de peças");
        System.out.println("10. Sair");
        System.out.print("Escolha: ");
    }

    private boolean procesarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> cadastrarPeca();
            case 2 -> buscarPeca();
            case 3 -> atualizarQuantidade();
            case 4 -> atualizarPreco();
            case 5 -> removerPeca();
            case 6 -> estoque.exibirEstoque();
            case 7 -> listarEstoqueBaixo();
            case 8 -> exibirValorTotal();
            case 9 -> exibirTotalPecas();
            case 10 -> {
                System.out.println("\nEncerrando...");
                return false;
            }
            default -> System.out.println("Opção inválida!");
        }
        return true;
    }

    private void cadastrarPeca() {
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        
        estoque.adicionarPeca(codigo, nome, quantidade, preco);
        System.out.println("✓ Peça cadastrada com sucesso!");
    }

    private void buscarPeca() {
        System.out.print("Código da peça: ");
        int codigo = scanner.nextInt();
        
        Peca peca = estoque.buscarPeca(codigo);
        if (peca != null) {
            System.out.println("\n" + peca);
        } else {
            System.out.println("✗ Peça não encontrada!");
        }
    }

    private void atualizarQuantidade() {
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        
        Peca peca = estoque.buscarPeca(codigo);
        if (peca != null) {
            System.out.print("Nova quantidade: ");
            int qtd = scanner.nextInt();
            estoque.atualizarQuantidade(codigo, qtd);
            System.out.println("✓ Atualizado!");
        } else {
            System.out.println("✗ Peça não encontrada!");
        }
    }

    private void atualizarPreco() {
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        
        Peca peca = estoque.buscarPeca(codigo);
        if (peca != null) {
            System.out.print("Novo preço: ");
            double preco = scanner.nextDouble();
            estoque.atualizarPreco(codigo, preco);
            System.out.println("✓ Atualizado!");
        } else {
            System.out.println("✗ Peça não encontrada!");
        }
    }

    private void removerPeca() {
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        
        Peca peca = estoque.buscarPeca(codigo);
        if (peca != null) {
            estoque.removerPeca(codigo);
            System.out.println("✓ Peça removida!");
        } else {
            System.out.println("✗ Peça não encontrada!");
        }
    }

    private void listarEstoqueBaixo() {
        System.out.print("Limite mínimo: ");
        int limite = scanner.nextInt();
        estoque.listarEstoqueBaixo(limite);
    }

    private void exibirValorTotal() {
        double valor = estoque.calcularValorEstoque();
        System.out.printf("\nValor total do estoque: R$ %.2f\n", valor);
    }

    private void exibirTotalPecas() {
        System.out.println("\nTotal de tipos diferentes: " + estoque.totalPecas());
    }

    private void carregarDadosTeste() {
        estoque.adicionarPeca(1001, "Óleo 5W30", 25, 35.50);
        estoque.adicionarPeca(1002, "Filtro de ar", 40, 28.00);
        estoque.adicionarPeca(1003, "Corrente de distribuição", 8, 280.00);
        estoque.adicionarPeca(1004, "Pastilha de freio", 15, 89.90);
        estoque.adicionarPeca(1005, "Vela de ignição", 60, 12.50);
        estoque.adicionarPeca(1006, "Bateria 60Ah", 5, 450.00);
        estoque.adicionarPeca(1007, "Radiador", 3, 350.00);
        estoque.adicionarPeca(1008, "Pneu 175/65R14", 12, 220.00);
        
        System.out.println("✓ Dados de teste carregados!\n");
    }

    public static void main(String[] args) {
        new SistemaEstoque().iniciar();
    }
}
