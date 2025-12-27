public class ArvoreAVL<T extends Comparable<T>> {
    private AVLNode<T> raiz;
    private int tamanho;

    public ArvoreAVL() {
        this.raiz = null;
        this.tamanho = 0;
    }

    // Retorna a altura de um nó -- IMPORTANTE
    private int altura(AVLNode<T> no) {
        return no == null ? 0 : no.altura;
    }

    // Atualiza a altura de um nó
    private void atualizarAltura(AVLNode<T> no) {
        if (no != null) {
            // qual o maior valor entre as alturas dos filhos + 1
            no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        }
    }

    // Calcula o fator de balanceamento - Fórmula padrão
    private int fatorBalanceamento(AVLNode<T> no) {
        return no == null ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    // Rotação à direita -- IMPORTANTE
    private AVLNode<T> rotacaoDireita(AVLNode<T> p) {
        AVLNode<T> q = p.esquerda;
        p.esquerda = q.direita;
        q.direita = p;
        
        // Atualizar a aultura é importante após rotações, pois a estrutura da árvore muda.
        atualizarAltura(p);
        atualizarAltura(q);
        
        return q;
    }

    // Rotação à esquerda 
    private AVLNode<T> rotacaoEsquerda(AVLNode<T> p) {
        AVLNode<T> q = p.direita;
        p.direita = q.esquerda;
        q.esquerda = p;
        
        atualizarAltura(p);
        atualizarAltura(q);
        
        return q;
    }

    // Balanceia um nó - com base na teoria de árvores AVL
    private AVLNode<T> balancear(AVLNode<T> no) {
        if (no == null) return null;

        atualizarAltura(no);
        int fb = fatorBalanceamento(no);

        // Caso Esquerda-Esquerda
        if (fb > 1 && fatorBalanceamento(no.esquerda) >= 0) {
            return rotacaoDireita(no);
        }

        // Caso Esquerda-Direita
        if (fb > 1 && fatorBalanceamento(no.esquerda) < 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        // Caso Direita-Direita
        if (fb < -1 && fatorBalanceamento(no.direita) <= 0) {
            return rotacaoEsquerda(no);
        }

        // Caso Direita-Esquerda
        if (fb < -1 && fatorBalanceamento(no.direita) > 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    // Inserir elemento
    public void inserir(T dado) {
        raiz = inserirRec(raiz, dado);
    }

    private AVLNode<T> inserirRec(AVLNode<T> no, T dado) {
        if (no == null) {
            tamanho++;
            return new AVLNode<>(dado);
        }

        // cmp é a comparação entre os dados para definir a posição de inserção.
        int cmp = dado.compareTo(no.dado);
        if (cmp < 0) {
            no.esquerda = inserirRec(no.esquerda, dado);
        } else if (cmp > 0) {
            no.direita = inserirRec(no.direita, dado);
        } else {
            return no; // Duplicado não é inserido
        }

        return balancear(no);
    }

    // Buscar elemento
    public boolean buscar(T dado) {
        return buscarRec(raiz, dado);
    }

    private boolean buscarRec(AVLNode<T> no, T dado) {
        if (no == null) return false;

        int cmp = dado.compareTo(no.dado);
        if (cmp < 0) {
            return buscarRec(no.esquerda, dado);
        } else if (cmp > 0) {
            return buscarRec(no.direita, dado);
        } else {
            return true;
        }
    }

    // Remover elemento
    public boolean remover(T dado) {
        if (!buscar(dado)) return false;
        raiz = removerRec(raiz, dado);
        return true;
    }

    private AVLNode<T> removerRec(AVLNode<T> no, T dado) {
        if (no == null) return null;

        int cmp = dado.compareTo(no.dado);
        if (cmp < 0) {
            no.esquerda = removerRec(no.esquerda, dado);
        } else if (cmp > 0) {
            no.direita = removerRec(no.direita, dado);
        } else {
            // Nó encontrado
            if (no.esquerda == null) {
                tamanho--;
                return no.direita;
            } else if (no.direita == null) {
                tamanho--;
                return no.esquerda;
            }

            // Nó com dois filhos - substitui pelo sucessor
            AVLNode<T> sucessor = encontrarMinimo(no.direita);
            no.dado = sucessor.dado;
            no.direita = removerRec(no.direita, sucessor.dado);
            tamanho--;
        }

        return balancear(no);
    }

    private AVLNode<T> encontrarMinimo(AVLNode<T> no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }

    // Retorna o menor elemento
    public T minimo() {
        if (vazia()) return null;
        return encontrarMinimo(raiz).dado;
    }

    // Retorna o maior elemento
    public T maximo() {
        if (vazia()) return null;
        AVLNode<T> no = raiz;
        while (no.direita != null) {
            no = no.direita;
        }
        return no.dado;
    }

    // Verifica se está vazia
    public boolean vazia() {
        return raiz == null;
    }

    // Retorna o tamanho
    public int tamanho() {
        return tamanho;
    }

    // Retorna a altura
    public int altura() {
        return altura(raiz);
    }

    // Limpa a árvore
    public void limpar() {
        raiz = null;
        tamanho = 0;
    }

    // Retorna a raiz
    public AVLNode<T> obterRaiz() {
        return raiz;
    }

    // Percurso em ordem - significa visitar o nó esquerdo, depois o nó atual, depois o nó direito
    public void emOrdem() {
        System.out.print("Em ordem: ");
        emOrdemRec(raiz);
        System.out.println();
    }

    private void emOrdemRec(AVLNode<T> no) {
        if (no != null) {
            emOrdemRec(no.esquerda);
            System.out.print(no.dado + " ");
            emOrdemRec(no.direita);
        }
    }

    // Percurso pré-ordem - significa visitar o nó atual, depois o nó esquerdo, depois o nó direito
    public void preOrdem() {
        System.out.print("Pré-ordem: ");
        preOrdemRec(raiz);
        System.out.println();
    }

    private void preOrdemRec(AVLNode<T> no) {
        if (no != null) {
            System.out.print(no.dado + " ");
            preOrdemRec(no.esquerda);
            preOrdemRec(no.direita);
        }
    }

    // Percurso pós-ordem - significa visitar o nó esquerdo, depois o nó direito, depois o nó atual
    public void posOrdem() {
        System.out.print("Pós-ordem: ");
        posOrdemRec(raiz);
        System.out.println();
    }

    private void posOrdemRec(AVLNode<T> no) {
        if (no != null) {
            posOrdemRec(no.esquerda);
            posOrdemRec(no.direita);
            System.out.print(no.dado + " ");
        }
    }

    // Exibir árvore
    public void exibir() {
        exibirRec(raiz, "", true);
    }

    private void exibirRec(AVLNode<T> no, String prefixo, boolean ehCauda) {
        if (no != null) {
            System.out.println(prefixo + (ehCauda ? "└── " : "├── ") + 
                             no.dado + " (h:" + no.altura + ", fb:" + fatorBalanceamento(no) + ")");
            
            if (no.esquerda != null || no.direita != null) {
                if (no.esquerda != null) {
                    exibirRec(no.esquerda, prefixo + (ehCauda ? "    " : "│   "), 
                             no.direita == null);
                }
                if (no.direita != null) {
                    exibirRec(no.direita, prefixo + (ehCauda ? "    " : "│   "), true);
                }
            }
        }
    }
}
