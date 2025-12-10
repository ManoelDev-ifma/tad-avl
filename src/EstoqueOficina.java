public class EstoqueOficina {
    private ArvoreAVL<Peca> estoque;

    public EstoqueOficina() {
        this.estoque = new ArvoreAVL<>();
    }

    public void adicionarPeca(int codigo, String nome, int quantidade, double preco) {
        Peca nova = new Peca(codigo, nome, quantidade, preco);
        estoque.inserir(nova);
    }

    public Peca buscarPeca(int codigo) {
        Peca dummy = new Peca(codigo, "", 0, 0);
        return buscaComCodigo(estoque.obterRaiz(), dummy);
    }

    private Peca buscaComCodigo(AVLNode<Peca> no, Peca alvo) {
        if (no == null) return null;
        
        int cmp = alvo.compareTo(no.dado);
        if (cmp < 0) return buscaComCodigo(no.esquerda, alvo);
        if (cmp > 0) return buscaComCodigo(no.direita, alvo);
        return no.dado;
    }

    public void atualizarQuantidade(int codigo, int novaQuantidade) {
        Peca peca = buscarPeca(codigo);
        if (peca != null) {
            peca.setQuantidade(novaQuantidade);
        }
    }

    public void atualizarPreco(int codigo, double novoPreco) {
        Peca peca = buscarPeca(codigo);
        if (peca != null) {
            peca.setPreco(novoPreco);
        }
    }

    public void removerPeca(int codigo) {
        Peca dummy = new Peca(codigo, "", 0, 0);
        estoque.remover(dummy);
    }

    public void exibirEstoque() {
        System.out.println("\n========== ESTOQUE COMPLETO ==========");
        exibirRec(estoque.obterRaiz());
        System.out.println("======================================\n");
    }

    private void exibirRec(AVLNode<Peca> no) {
        if (no != null) {
            exibirRec(no.esquerda);
            System.out.println(no.dado);
            exibirRec(no.direita);
        }
    }

    public void listarEstoqueBaixo(int limiteMinimo) {
        System.out.println("\n===== PEÇAS COM ESTOQUE BAIXO (" + limiteMinimo + ") =====");
        listarBaixoRec(estoque.obterRaiz(), limiteMinimo);
        System.out.println("=========================================\n");
    }

    private void listarBaixoRec(AVLNode<Peca> no, int limite) {
        if (no != null) {
            listarBaixoRec(no.esquerda, limite);
            if (no.dado.getQuantidade() < limite) {
                System.out.println("⚠️  " + no.dado);
            }
            listarBaixoRec(no.direita, limite);
        }
    }

    public double calcularValorEstoque() {
        return calcularValorRec(estoque.obterRaiz());
    }

    private double calcularValorRec(AVLNode<Peca> no) {
        if (no == null) return 0;
        
        double valor = no.dado.getQuantidade() * no.dado.getPreco();
        return valor + calcularValorRec(no.esquerda) + calcularValorRec(no.direita);
    }

    public int totalPecas() {
        return estoque.tamanho();
    }

    public void obterRaiz() {
        estoque.exibir();
    }
}
