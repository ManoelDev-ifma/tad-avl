package tad_rb.avl;

/**
 * Implementação AVL com contadores de rotação
 */
public class ArvoreAVL<T extends Comparable<T>> {
    private AVLNode<T> raiz;
    private int tamanho;
    private long rotacoesEsquerda = 0;
    private long rotacoesDireita = 0;

    public ArvoreAVL() {
        this.raiz = null;
        this.tamanho = 0;
    }

    private int altura(AVLNode<T> no) {
        return no == null ? 0 : no.altura;
    }

    private void atualizarAltura(AVLNode<T> no) {
        if (no != null) {
            no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        }
    }

    private int fatorBalanceamento(AVLNode<T> no) {
        return no == null ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    private AVLNode<T> rotacaoDireita(AVLNode<T> p) {
        AVLNode<T> q = p.esquerda;
        p.esquerda = q.direita;
        q.direita = p;
        atualizarAltura(p);
        atualizarAltura(q);
        rotacoesDireita++;
        return q;
    }

    private AVLNode<T> rotacaoEsquerda(AVLNode<T> p) {
        AVLNode<T> q = p.direita;
        p.direita = q.esquerda;
        q.esquerda = p;
        atualizarAltura(p);
        atualizarAltura(q);
        rotacoesEsquerda++;
        return q;
    }

    private AVLNode<T> balancear(AVLNode<T> no) {
        if (no == null) return null;
        atualizarAltura(no);
        int fb = fatorBalanceamento(no);
        if (fb > 1 && fatorBalanceamento(no.esquerda) >= 0) {
            return rotacaoDireita(no);
        }
        if (fb > 1 && fatorBalanceamento(no.esquerda) < 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }
        if (fb < -1 && fatorBalanceamento(no.direita) <= 0) {
            return rotacaoEsquerda(no);
        }
        if (fb < -1 && fatorBalanceamento(no.direita) > 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }
        return no;
    }

    public void inserir(T dado) {
        raiz = inserirRec(raiz, dado);
    }

    private AVLNode<T> inserirRec(AVLNode<T> no, T dado) {
        if (no == null) {
            tamanho++;
            return new AVLNode<>(dado);
        }
        int cmp = dado.compareTo(no.dado);
        if (cmp < 0) no.esquerda = inserirRec(no.esquerda, dado);
        else if (cmp > 0) no.direita = inserirRec(no.direita, dado);
        else return no;
        return balancear(no);
    }

    public boolean buscar(T dado) { return buscarRec(raiz, dado); }
    private boolean buscarRec(AVLNode<T> no, T dado) {
        if (no == null) return false;
        int cmp = dado.compareTo(no.dado);
        if (cmp < 0) return buscarRec(no.esquerda, dado);
        else if (cmp > 0) return buscarRec(no.direita, dado);
        else return true;
    }

    public boolean remover(T dado) {
        if (!buscar(dado)) return false;
        raiz = removerRec(raiz, dado);
        return true;
    }

    private AVLNode<T> removerRec(AVLNode<T> no, T dado) {
        if (no == null) return null;
        int cmp = dado.compareTo(no.dado);
        if (cmp < 0) no.esquerda = removerRec(no.esquerda, dado);
        else if (cmp > 0) no.direita = removerRec(no.direita, dado);
        else {
            if (no.esquerda == null) { tamanho--; return no.direita; }
            else if (no.direita == null) { tamanho--; return no.esquerda; }
            AVLNode<T> sucessor = encontrarMinimo(no.direita);
            no.dado = sucessor.dado;
            no.direita = removerRec(no.direita, sucessor.dado);
            tamanho--;
        }
        return balancear(no);
    }

    private AVLNode<T> encontrarMinimo(AVLNode<T> no) {
        while (no.esquerda != null) no = no.esquerda;
        return no;
    }

    public T minimo() { if (vazia()) return null; return encontrarMinimo(raiz).dado; }
    public T maximo() { if (vazia()) return null; AVLNode<T> no = raiz; while (no.direita != null) no = no.direita; return no.dado; }
    public boolean vazia() { return raiz == null; }
    public int tamanho() { return tamanho; }
    public int altura() { return altura(raiz); }
    public void limpar() { raiz = null; tamanho = 0; }
    public AVLNode<T> obterRaiz() { return raiz; }
    public long getRotacoesEsquerda() { return rotacoesEsquerda; }
    public long getRotacoesDireita() { return rotacoesDireita; }

    // impressões simples
    public void emOrdem() { System.out.print("Em ordem: "); emOrdemRec(raiz); System.out.println(); }
    private void emOrdemRec(AVLNode<T> no) { if (no != null) { emOrdemRec(no.esquerda); System.out.print(no.dado + " "); emOrdemRec(no.direita); } }

}
