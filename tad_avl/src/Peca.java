public class Peca implements Comparable<Peca> {
    private int codigo;
    private String nome;
    private int quantidade;
    private double preco;

    public Peca(int codigo, String nome, int quantidade, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public int compareTo(Peca outra) {
        return Integer.compare(this.codigo, outra.codigo);
    }

    @Override
    public String toString() {
        return String.format("[%d] %s | Qtd: %d | R$ %.2f", 
            codigo, nome, quantidade, preco);
    }
}
