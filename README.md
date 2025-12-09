# Árvore AVL em Português

Implementação de uma Árvore AVL (Árvore Binária de Busca Auto-Balanceada) em Java com Generics.

## O que é?

Uma Árvore AVL mantém o balanceamento automático garantindo que a diferença de altura entre as subárvores esquerda e direita de qualquer nó seja no máximo 1.

**Propriedade AVL:** `|altura_esquerda - altura_direita| ≤ 1`

Isso garante que todas as operações sejam **O(log n)**.

## Como Usar

### Compilar
```bash
cd src
javac AVLNode.java ArvoreAVL.java TesteArvoreAVL.java
```

### Executar Testes
```bash
java TesteArvoreAVL
```

### Usando o Script
```bash
./simples.sh         # Compilar
./simples.sh teste   # Executar testes
./simples.sh limpar  # Limpar .class
```

## Exemplo de Código

```java
// Criar árvore de inteiros
ArvoreAVL<Integer> arvore = new ArvoreAVL<>();

// Inserir elementos
arvore.inserir(50);
arvore.inserir(30);
arvore.inserir(70);
arvore.inserir(20);
arvore.inserir(40);

// Buscar
boolean encontrou = arvore.buscar(30);  // true

// Informações
System.out.println("Tamanho: " + arvore.tamanho());      // 5
System.out.println("Altura: " + arvore.altura());        // 3
System.out.println("Mínimo: " + arvore.minimo());        // 20
System.out.println("Máximo: " + arvore.maximo());        // 70

// Visualizar
arvore.exibir();    // Mostra estrutura visual
arvore.emOrdem();   // 20 30 40 50 70

// Remover
arvore.remover(30);

// Limpar
arvore.limpar();
```

## Métodos Disponíveis

### Operações Básicas
- `inserir(dado)` - Insere elemento na árvore
- `remover(dado)` - Remove elemento da árvore
- `buscar(dado)` - Busca um elemento (retorna boolean)
- `minimo()` - Retorna o menor elemento
- `maximo()` - Retorna o maior elemento

### Informações
- `tamanho()` - Número de elementos na árvore
- `altura()` - Altura da árvore
- `vazia()` - Verifica se a árvore está vazia
- `limpar()` - Remove todos os elementos

### Percursos
- `emOrdem()` - Percurso em ordem (esquerda → raiz → direita)
- `preOrdem()` - Percurso pré-ordem (raiz → esquerda → direita)
- `posOrdem()` - Percurso pós-ordem (esquerda → direita → raiz)

### Visualização
- `exibir()` - Exibe a árvore com altura (h) e fator de balanceamento (fb)

## Estrutura dos Arquivos

```
tad_avl/
├── src/
│   ├── AVLNode.java          # Estrutura do nó
│   ├── ArvoreAVL.java        # Implementação da árvore
│   └── TesteArvoreAVL.java   # Testes
├── simples.sh                # Script de compilação
├── .gitignore                # Arquivos ignorados
└── README.md                 # Este arquivo
```

## Rotações Implementadas

A árvore implementa as 4 rotações necessárias para manter o balanceamento:

1. **Rotação Direita (LL)** - Quando desbalanceia à esquerda-esquerda
2. **Rotação Esquerda (RR)** - Quando desbalanceia à direita-direita  
3. **Rotação Dupla Direita (LR)** - Quando desbalanceia esquerda-direita
4. **Rotação Dupla Esquerda (RL)** - Quando desbalanceia direita-esquerda

## Complexidade

Todas as operações principais têm complexidade **O(log n)**:
- Inserção: O(log n)
- Remoção: O(log n)
- Busca: O(log n)
- Mínimo/Máximo: O(log n)

## Exemplo de Saída

```
🌳 Árvore:
└── 50 (h:3, fb:0)
    ├── 30 (h:2, fb:0)
    │   ├── 20 (h:1, fb:0)
    │   └── 40 (h:1, fb:0)
    └── 70 (h:2, fb:0)
        ├── 60 (h:1, fb:0)
        └── 80 (h:1, fb:0)

Em ordem: 20 30 40 50 60 70 80
```

Onde:
- **h** = altura do nó
- **fb** = fator de balanceamento (altura_esq - altura_dir)

## Funciona com Generics

A árvore funciona com qualquer tipo que implemente `Comparable`:

```java
// Inteiros
ArvoreAVL<Integer> numeros = new ArvoreAVL<>();
numeros.inserir(10);

// Strings
ArvoreAVL<String> nomes = new ArvoreAVL<>();
nomes.inserir("Ana");
nomes.inserir("Bruno");
nomes.inserir("Carlos");

// Doubles
ArvoreAVL<Double> valores = new ArvoreAVL<>();
valores.inserir(3.14);
```

## Características

✅ Código limpo e direto  
✅ Métodos em português  
✅ Auto-balanceamento automático  
✅ Suporte a Generics  
✅ Visualização clara da estrutura  
✅ Testes completos incluídos  
✅ Complexidade O(log n) garantida  

---

**Desenvolvido para Estruturas de Dados II**  
*8 de dezembro de 2025*
# tad-avl
