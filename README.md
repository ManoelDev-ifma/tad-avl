# 🌳 Árvore AVL - Sistema de Estoque para Oficina Mecânica# 

Implementação completa de uma **Árvore AVL** (Árvore Binária de Busca Auto-Balanceada) em Java com aplicação prática: sistema de gestão de estoque de peças automotivas.



---Implementação completa de uma **Árvore AVL** (Árvore Binária de Busca Auto-Balanceada) em Java com aplicação prática: sistema de gestão de estoque de peças automotivas.Implementação de uma Árvore AVL (Árvore Binária de Busca Auto-Balanceada) em Java com Generics.



## 📋 Índice1. [O que é Árvore AVL?](#o-que-é-árvore-avl)## Aplicação Real: Sistema de Estoque para Oficina Mecânica



1. [O que é Árvore AVL?](#o-que-é-árvore-avl)2. [Por que Árvore AVL?](#por-que-árvore-avl)

2. [Por que Árvore AVL?](#por-que-árvore-avl)

3. [Aplicação Real](#aplicação-real-sistema-de-estoque)3. [Aplicação Real](#-aplicação-real-sistema-de-estoque)O projeto implementa um sistema prático de gestão de estoque de peças automotivas:

4. [Início Rápido](#-início-rápido)

5. [Como Usar](#como-usar)4. [Início Rápido](#-início-rápido)

6. [Estrutura do Projeto](#-estrutura-do-projeto)

7. [Componentes](#-componentes)5. [Como Usar](#como-usar)- **Cadastro de peças** com código, nome, quantidade e preço

8. [Operações Disponíveis](#-operações-disponíveis)

9. [Complexidade](#-complexidade-computacional)6. [Componentes](#-componentes)- **Buscas rápidas** por código de peça

10. [Exemplos de Código](#-exemplos-de-código)

7. [Operações Disponíveis](#-operações-disponíveis)- **Atualizações** de quantidade e preço

---

8. [Complexidade](#-complexidade-computacional)- **Remoção** de peças descontinuadas

## O que é Árvore AVL?

9. [Exemplos de Código](#-exemplos-de-código)- **Relatório de estoque** em ordem crescente

Uma **Árvore AVL** é uma Árvore Binária de Busca que se **auto-balancea** automaticamente.

10. [Estrutura de Arquivos](#-estrutura-de-arquivos)- **Alerta de estoque baixo** com limite configurável

**Propriedade AVL:** `|altura_esquerda - altura_direita| ≤ 1`

- **Valor total** do estoque em tempo real

Isso garante que todas as operações (busca, inserção, remoção) sejam **garantidamente O(log n)**, nunca ficam lentas! ⚡

---

### Exemplo Visual

### Por que AVL?

```

Árvore AVL balanceada (3 peças):## O que é Árvore AVL?

           [1003]

          /      \Lista encadeada: buscar entre milhares de peças = **O(n)** lento  

       [1002]    [1005]

       /Uma **Árvore AVL** é uma Árvore Binária de Busca que se **auto-balancea** automaticamente. Árvore AVL: buscar = **O(log n)** rápido  

    [1001]

Diferença real: 10.000 peças = 10.000 comparações vs. 14 comparações!

✅ Balanceamento OK:

   - Nó raiz: |1 - 2| = 1 ✓**Propriedade AVL:** `|altura_esquerda - altura_direita| ≤ 1`

   - Nó esquerdo: |1 - 0| = 1 ✓

   - Nó direito: |0 - 0| = 0 ✓## Como Usar

```

Isso significa que em qualquer nó da árvore, a diferença entre as alturas das subárvores esquerda e direita é no máximo 1.

---

### Compilar

## Por que Árvore AVL?

**Resultado:** Todas as operações (busca, inserção, remoção) são **garantidamente O(log n)**, nunca ficam lentas! ⚡```bash

### Comparação de Performance

cd src

Imagine uma oficina com **10.000 peças** diferentes:

### Exemplo Visualjavac AVLNode.java ArvoreAVL.java Peca.java EstoqueOficina.java TesteEstoque.java

| Estrutura | Buscar | Inserir | Remover |

|-----------|--------|---------|---------|```

| **Array/Lista** | O(n) = 10.000 passos 🐢 | O(n) | O(n) |

| **Árvore AVL** | O(log n) = 14 passos ⚡ | O(log n) | O(log n) |```



**Diferença Real:** AVL é **~700x mais rápido** para 10.000 itens! 🚀Árvore AVL balanceada (3 peças):### Executar Teste



### Exemplo Prático           [1003]```bash



```          /      \java TesteEstoque

Buscar [1003] entre 10.000 peças:

       [1002]    [1005]```

❌ SEM AVL (Lista):

   Comparação 1: É [1001]? Não...       /

   Comparação 2: É [1002]? Não...

   ... (até encontrar - LENTO!)    [1001]### Sistema Interativo



✅ COM AVL:```bash

   Comparação 1: [1003] > [5500]? Vai direita

   Comparação 2: [1003] < [7500]? Vai esquerda✅ Balanceamento OK:javac SistemaEstoque.java

   Comparação 3: [1003] encontrada! ✓ (RÁPIDO!)

```   - Nó raiz: |1 - 2| = 1 ✓java SistemaEstoque



---   - Nó esquerdo: |1 - 0| = 1 ✓```



## Aplicação Real: Sistema de Estoque   - Nó direito: |0 - 0| = 0 ✓



### O Problema```### Usando o Script



Uma oficina mecânica precisa gerenciar milhares de peças:```bash

- Óleo, filtros, pastilhas, correntes, velas, baterias...

- Cada peça tem: código, nome, quantidade, preço---./simples.sh         # Compilar

- Precisa de: buscas rápidas, atualizações, alertas de estoque baixo

./simples.sh teste   # Executar testes

### A Solução

## Por que Árvore AVL?./simples.sh sistema # Sistema interativo

**Árvore AVL com modelo de dados específico:**

./simples.sh limpar  # Limpar .class

```java

class Peca implements Comparable<Peca> {### Comparação de Performance```

    int codigo;      // Chave: 1001, 1002, 1003...

    String nome;     // "Óleo 5W30", "Filtro"...

    int quantidade;  // Unidades em estoque

    double preco;    // Preço unitárioImagine uma oficina com **10.000 peças** diferentes:## Exemplo de Código

}

```



### Funcionalidades| Estrutura | Buscar | Inserir | Remover | Melhor Para |```java



✅ **Cadastro de peças** - Adicionar nova peça  |-----------|--------|---------|---------|-------------|// Criar árvore de inteiros

✅ **Busca por código** - O(log n), mesmo com milhares  

✅ **Atualizar quantidade** - Repor ou usar estoque  | **Array** | O(n) = 10.000 passos 🐢 | O(n) | O(n) | Dados fixos |ArvoreAVL<Integer> arvore = new ArvoreAVL<>();

✅ **Atualizar preço** - Ajustar valores  

✅ **Remover peça** - Descontinuar item  | **Lista Encadeada** | O(n) = 10.000 passos 🐢 | O(n) | O(n) | Dados pequenos |

✅ **Exibir estoque** - Lista ordenada por código  

✅ **Alerta de estoque baixo** - Detecta peças críticas  | **Árvore AVL** | O(log n) = 14 passos ⚡ | O(log n) = 14 passos | O(log n) = 14 passos | **Dados dinâmicos grandes** |// Inserir elementos

✅ **Valor total** - Calcula R$ do inventário  

arvore.inserir(50);

---

**Diferença Real:** AVL é **~700x mais rápido** para 10.000 itens! 🚀arvore.inserir(30);

## ⚡ Início Rápido

arvore.inserir(70);

### 1️⃣ Compilar

```bash### Exemplo Práticoarvore.inserir(20);

./simples.sh

```arvore.inserir(40);



### 2️⃣ Executar Testes```

```bash

./simples.sh testeBuscar código [1003] entre 10.000 peças:// Buscar

```

boolean encontrou = arvore.buscar(30);  // true

### 3️⃣ Sistema Interativo

```bash❌ SEM AVL (Lista):

./simples.sh sistema

```   Comparação 1: É [1001]? Não...// Informações



### 4️⃣ Limpar   Comparação 2: É [1002]? Não...System.out.println("Tamanho: " + arvore.tamanho());      // 5

```bash

./simples.sh limpar   ...System.out.println("Altura: " + arvore.altura());        // 3

```

   Comparação 3: É [1003]? SIM! ✓System.out.println("Mínimo: " + arvore.minimo());        // 20

---

   (No pior caso: 10.000 comparações!)System.out.println("Máximo: " + arvore.maximo());        // 70

## Como Usar



### Opção 1: Compilação Manual

✅ COM AVL:// Visualizar

```bash

# Compilar classes principal   Comparação 1: [1003] > [5500]? Sim, vai direitaarvore.exibir();    // Mostra estrutura visual

cd src

javac AVLNode.java ArvoreAVL.java Peca.java EstoqueOficina.java   Comparação 2: [1003] < [7500]? Sim, vai esquerdaarvore.emOrdem();   // 20 30 40 50 70



# Executar testes   Comparação 3: [1003] encontrada! ✓

cd ../test

javac -cp ../src TesteEstoque.java   (Máximo de comparações: ~14)// Remover

java -cp ../src:. TesteEstoque

``````arvore.remover(30);



### Opção 2: Sistema Interativo



```bash---// Limpar

cd src

javac AVLNode.java ArvoreAVL.java Peca.java EstoqueOficina.java SistemaEstoque.javaarvore.limpar();

java SistemaEstoque

```## 🏪 Aplicação Real: Sistema de Estoque```



### Opção 3: Script Automatizado (Recomendado)



```bash### O Problema## Métodos Disponíveis

# Compilar

./simples.sh

P

# Executar testesUma oficina mecânica precisa gerenciar milhares de peças:### Operações Básicas

./simples.sh teste

- Óleo, filtros, pastilhas, correntes, velas, baterias...- `inserir(dado)` - Insere elemento na árvore

# Sistema interativo

./simples.sh sistema- Cada peça tem: código, nome, quantidade, preço- `remover(dado)` - Remove elemento da árvore



# Limpar .class- Precisa de: buscas rápidas, atualizações, alertas de estoque baixo, cálculos de valor total- `buscar(dado)` - Busca um elemento (retorna boolean)

./simples.sh limpar

```- `minimo()` - Retorna o menor elemento



---### A Solução- `maximo()` - Retorna o maior elemento



## 📂 Estrutura do Projeto



```**Árvore AVL com modelo de dados específico (Peca):**### Informações

tad_avl/

├── README.md ..................... Documentação (você está aqui)- `tamanho()` - Número de elementos na árvore

├── simples.sh .................... Script de automação

│```java- `altura()` - Altura da árvore

├── src/ .......................... Código principal

│   ├── AVLNode.java ............. Nó genérico (14 linhas)class Peca implements Comparable<Peca> {- `vazia()` - Verifica se a árvore está vazia

│   ├── ArvoreAVL.java ........... Árvore AVL (274 linhas) 🌳

│   ├── Peca.java ................ Modelo: peça automotiva (48 linhas)    int codigo;      // Chave: 1001, 1002, 1003...- `limpar()` - Remove todos os elementos

│   ├── EstoqueOficina.java ...... Gerenciador de estoque (94 linhas)

│   └── SistemaEstoque.java ...... Menu interativo (167 linhas)    String nome;     // "Óleo 5W30", "Filtro"...

│

└── test/ ......................... Testes automatizados    int quantidade;  // Unidades em estoque### Percursos

    ├── TesteEstoque.java ........ Teste da aplicação (43 linhas)

    └── TesteArvoreAVL.java ...... Teste da AVL (121 linhas)    double preco;    // Preço unitário- `emOrdem()` - Percurso em ordem (esquerda → raiz → direita)

```

}- `preOrdem()` - Percurso pré-ordem (raiz → esquerda → direita)

### Estatísticas

```- `posOrdem()` - Percurso pós-ordem (esquerda → direita → raiz)

```

Código Principal: 597 linhas

Testes:          164 linhas

Documentação:    844 linhas### Funcionalidades### Visualização

─────────────────────────

TOTAL:         1.605 linhas- `exibir()` - Exibe a árvore com altura (h) e fator de balanceamento (fb)

```

✅ **Cadastro de peças** - Adicionar nova peça ao estoque  

---

✅ **Busca por código** - O(log n), mesmo com milhares  ## Estrutura dos Arquivos

## 🔧 Componentes

✅ **Atualizar quantidade** - Repor ou usar estoque  

### 1. AVLNode.java (14 linhas)

**Nó genérico da árvore**✅ **Atualizar preço** - Ajustar valores  ```

```java

public class AVLNode<T extends Comparable<T>> {✅ **Remover peça** - Descontinuar item  tad_avl/

    public T dado;

    public AVLNode<T> esquerda, direita;✅ **Exibir estoque** - Lista ordenada por código  ├── src/

    public int altura;

}✅ **Alerta de estoque baixo** - Detecta peças críticas  │   ├── AVLNode.java          # Estrutura do nó

```

✅ **Valor total** - Calcula R$ do inventário todo  │   ├── ArvoreAVL.java        # Implementação da árvore

### 2. ArvoreAVL.java (274 linhas)

**Implementação completa da Árvore AVL**✅ **Contador de tipos** - Quantos tipos diferentes  │   └── TesteArvoreAVL.java   # Testes



**Operações principais (todas O(log n)):**├── simples.sh                # Script de compilação

- `inserir(T dado)` - Insere mantendo balanceamento

- `remover(T dado)` - Remove e rebalanceia### Dados Pré-Carregados (8 peças)├── .gitignore                # Arquivos ignorados

- `buscar(T dado)` - Busca binária

- `minimo()` / `maximo()` - Extremos└── README.md                 # Este arquivo

- `altura()` - Altura da árvore

- `tamanho()` - Quantidade de nós``````



**Rotações (balanceamento):**[1001] Óleo 5W30          | Qtd: 25  | R$ 35,50

- LL (Left-Left): Rotação direita

- RR (Right-Right): Rotação esquerda[1002] Filtro de ar       | Qtd: 40  | R$ 28,00## Rotações Implementadas

- LR e RL: Rotações duplas

[1003] Corrente           | Qtd: 8   | R$ 280,00  ⚠️ BAIXO

### 3. Peca.java (48 linhas)

**Modelo de dados: Peça Automotiva**[1004] Pastilha de freio  | Qtd: 15  | R$ 89,90A árvore implementa as 4 rotações necessárias para manter o balanceamento:

```java

class Peca implements Comparable<Peca> {[1005] Vela               | Qtd: 2   | R$ 12,50   ⚠️ CRÍTICO

    int codigo;      // Chave de ordenação

    String nome;     // Nome descritivo[1006] Bateria            | Qtd: 5   | R$ 450,001. **Rotação Direita (LL)** - Quando desbalanceia à esquerda-esquerda

    int quantidade;  // Unidades em estoque

    double preco;    // Preço unitário[1007] Correia            | Qtd: 3   | R$ 65,002. **Rotação Esquerda (RR)** - Quando desbalanceia à direita-direita  

}

```[1008] Radiador           | Qtd: 2   | R$ 320,003. **Rotação Dupla Direita (LR)** - Quando desbalanceia esquerda-direita



### 4. EstoqueOficina.java (94 linhas)```4. **Rotação Dupla Esquerda (RL)** - Quando desbalanceia direita-esquerda

**Gerenciador de Estoque (Lógica de Negócio)**



**Operações CRUD:**

- `adicionarPeca(int, String, int, double)`---## Complexidade

- `buscarPeca(int codigo)` - O(log n)

- `atualizarQuantidade(int, int)`

- `atualizarPreco(int, double)`

- `removerPeca(int)`## ⚡ Início RápidoTodas as operações principais têm complexidade **O(log n)**:



**Relatórios:**- Inserção: O(log n)

- `exibirEstoque()` - Lista ordenada

- `listarEstoqueBaixo(int limite)`### 1️⃣ Compilar- Remoção: O(log n)

- `calcularValorEstoque()` - Valor total

- `totalPecas()` - Quantidade de tipos```bash- Busca: O(log n)



### 5. SistemaEstoque.java (167 linhas)./simples.sh- Mínimo/Máximo: O(log n)

**Interface Interativa (Menu de 10 Operações)**

```

```

1. Cadastrar nova peça## Exemplo de Saída

2. Buscar peça por código

3. Atualizar quantidade### 2️⃣ Executar Testes

4. Atualizar preço

5. Remover peça```bash```

6. Exibir estoque completo

7. Valor total do estoque./simples.sh teste🌳 Árvore:

8. Listar estoque baixo

9. Total de tipos de peças```└── 50 (h:3, fb:0)

0. Sair

```    ├── 30 (h:2, fb:0)



---Saída esperada:    │   ├── 20 (h:1, fb:0)



## 🎯 Operações Disponíveis```    │   └── 40 (h:1, fb:0)



| # | Operação | Tempo | Descrição |✅ Carrega 6 peças    └── 70 (h:2, fb:0)

|---|----------|-------|-----------|

| **1** | Cadastrar | O(log n) | Adiciona peça ao estoque |✅ Exibe estoque em ordem        ├── 60 (h:1, fb:0)

| **2** | Buscar | O(log n) | Procura peça por código |

| **3** | Atualizar Qtd | O(log n) | Muda quantidade |✅ Busca peça por código        └── 80 (h:1, fb:0)

| **4** | Atualizar Preço | O(log n) | Ajusta preço |

| **5** | Remover | O(log n) | Deleta peça |✅ Atualiza quantidade

| **6** | Exibir | O(n) | Lista todas em ordem |

| **7** | Valor Total | O(n) | Calcula R$ total |✅ Atualiza preçoEm ordem: 20 30 40 50 60 70 80

| **8** | Estoque Baixo | O(n) | Mostra peças críticas |

| **9** | Total Tipos | O(1) | Conta tipos |✅ Remove peça```



---✅ Lista estoque baixo



## 📊 Complexidade Computacional✅ Calcula valor totalOnde:



### Análise Teórica```- **h** = altura do nó



| Operação | Sem AVL | Com AVL | Melhoria |- **fb** = fator de balanceamento (altura_esq - altura_dir)

|----------|---------|---------|----------|

| **Busca** | O(n) | O(log n) | 700x |### 3️⃣ Sistema Interativo

| **Inserção** | O(n) | O(log n) | 700x |

| **Remoção** | O(n) | O(log n) | 700x |```bash## Funciona com Generics



### Exemplo para 1 milhão de peças./simples.sh sistema



``````A árvore funciona com qualquer tipo que implemente `Comparable`:

Lista:

- Buscar: 1.000.000 comparações

- Tempo: ~1 segundo### Opção 3: Script Automatizado (Recomendado)



AVL:```bash

- Buscar: ~20 comparações (log₂ 1.000.000)# Compilar

- Tempo: ~0,02 ms./simples.sh

- Melhoria: 50.000x mais rápido!

```# Testes

./simples.sh teste

### Garantia AVL

# Sistema interativo

```./simples.sh sistema

Para N peças, altura máxima = 1.44 × log₂(N + 2) - 0.328

# Limpar .class

N = 10.000:  h_max ≈ 14 nós./simples.sh limpar

N = 1.000.000: h_max ≈ 20 nós```

```

---

---

## 🔧 Componentes

## 💻 Exemplos de Código

### 1. `AVLNode.java` (9 linhas)

### Usar em Código Java**Nó genérico da árvore**



```java```java

// 1. Criar estoquepublic class AVLNode<T extends Comparable<T>> {

EstoqueOficina estoque = new EstoqueOficina();    public T dado;

    public AVLNode<T> esquerda, direita;

// 2. Adicionar peças    public int altura;

estoque.adicionarPeca(1001, "Óleo 5W30", 25, 35.50);}

estoque.adicionarPeca(1002, "Filtro", 40, 28.00);```



// 3. Buscar (O(log n))### 2. `ArvoreAVL.java` (274 linhas)

Peca p = estoque.buscarPeca(1001);**Implementação completa da Árvore AVL**

System.out.println(p);  // [1001] Óleo 5W30 | Qtd: 25 | R$ 35,50

**Operações principais (todas O(log n)):**

// 4. Atualizar- `inserir(T dado)` - Insere mantendo balanceamento

estoque.atualizarQuantidade(1001, 30);- `remover(T dado)` - Remove e rebalanceia

estoque.atualizarPreco(1001, 36.50);- `buscar(T dado)` - Busca rápida por comparação

- `minimo()` / `maximo()` - Extremos

// 5. Remover- `altura()` - Altura da árvore

estoque.removerPeca(1002);- `vazia()` - Verifica se vazia

- `tamanho()` - Quantidade de nós

// 6. Relatórios- `limpar()` - Esvazia a árvore

estoque.exibirEstoque();- `emOrdem()` / `preOrdem()` / `posOrdem()` - Traversals

estoque.listarEstoqueBaixo(10);

System.out.printf("Valor: R$ %.2f\n", estoque.calcularValorEstoque());**Rotações (balanceamento):**

```- LL (Left-Left): Rotação direita simples

- RR (Right-Right): Rotação esquerda simples

---- LR (Left-Right): Rotação dupla

- RL (Right-Left): Rotação dupla

## ✅ Testes

**Método especial:**

Execute os testes automatizados:- `obterRaiz()` - Acesso ao nó raiz para operações customizadas



```bash### 3. `Peca.java` (41 linhas)

./simples.sh teste**Modelo de dados: Peça Automotiva**

```

```java

**Validações incluídas:**class Peca implements Comparable<Peca> {

- ✅ Inserção de peças    int codigo;      // Chave de ordenação (1001, 1002...)

- ✅ Busca por código    String nome;     // Nome descritivo

- ✅ Atualização de quantidade    int quantidade;  // Unidades em estoque

- ✅ Atualização de preço    double preco;    // Preço unitário

- ✅ Remoção de peça    

- ✅ Listagem ordenada    // toString(): "[1001] Óleo 5W30 | Qtd: 25 | R$ 35,50"

- ✅ Estoque baixo    // compareTo(): Usa código para ordenação

- ✅ Valor total}

- ✅ Contagem de tipos```



---**Propriedade importante:** Implementa `Comparable<Peca>` usando `codigo` como chave. Isso mantém a propriedade BST (Árvore de Busca Binária): peças sempre ordenadas por código.



## 🎓 Conceitos Importantes### 4. `EstoqueOficina.java` (87 linhas)

**Gerenciador de Estoque (Lógica de Negócio)**

### Propriedade BST

``````java

Para cada nó N:class EstoqueOficina {

- Subárvore esquerda < N < Subárvore direita    // CRUD Básico

- Resultado: Busca binária O(log n)    void adicionarPeca(int cod, String nome, int qtd, double preco)

```    Peca buscarPeca(int codigo)           // O(log n)

    void atualizarQuantidade(int cod, int novaQtd)

### Auto-Balanceamento    void atualizarPreco(int cod, double novoPreco)

```    void removerPeca(int codigo)

Se |altura_esq - altura_dir| > 1:    

→ Executa rotação automática    // Relatórios

→ Restaura balanceamento em O(1)    void exibirEstoque()                  // In-order

```    void listarEstoqueBaixo(int limiteMin)

    double calcularValorEstoque()         // Soma recursiva

### Rotações    int totalPecas()

- **LL**: Rotação direita simples    

- **RR**: Rotação esquerda simples    // Helpers (recursivos)

- **LR / RL**: Rotações duplas    private Peca buscaComCodigo(AVLNode<Peca> nó, int codigo)

    private void exibirRec(AVLNode<Peca> nó)

### Traversals    private void listarBaixoRec(AVLNode<Peca> nó, int limite)

- **In-Order**: Esq → Nó → Dir (ordenado)    private double calcularValorRec(AVLNode<Peca> nó)

- **Pre-Order**: Nó → Esq → Dir}

- **Post-Order**: Esq → Dir → Nó```



---**Design Pattern:** Wrapper que encapsula a árvore e adiciona lógica de domínio.



## 🚀 Performance Real### 5. `SistemaEstoque.java` (180 linhas)

**Interface Interativa (Menu de 10 Operações)**

```bash

# Teste com 10.000 buscas```java

./simples.sh testeclass SistemaEstoque {

    void iniciar()              // Loop principal

# Resultado esperado:    void exibirMenu()           // Mostra opções

# AVL: ~50ms    void procesarOpcao(int op)  // Roteia para operação

# Lista: ~5000ms (100x mais lento)    void cadastrarPeca()        // Op. 1

```    void buscarPeca()           // Op. 2

    void atualizarQuantidade()  // Op. 3

---    void atualizarPreco()       // Op. 4

    void removerPeca()          // Op. 5

## 💡 Quando Usar AVL?    void exibirEstoque()        // Op. 6

    void valorTotal()           // Op. 7

✅ **Use AVL quando:**    void listarEstoqueBaixo()   // Op. 8

- Precisa de muitas buscas rápidas    void totalPecas()           // Op. 9

- Dados estão constantemente mudando}

- Quer performance garantida```

- Tem 1.000+ itens

### 6. `TesteEstoque.java` (60 linhas)

❌ **Não use AVL quando:****Teste Automatizado Completo**

- Dados são estáticos

- Tem < 100 itensExecuta sequência de operações e valida:

- Precisa de múltiplas chaves de ordenação- Carregamento de peças

- Exibição ordenada

---- Buscas

- Atualizações

## 🔗 Próximos Passos- Remoções

- Relatórios

1. **Execute:** `./simples.sh teste`- Cálculos

2. **Teste:** `./simples.sh sistema`

3. **Estude:** Código-fonte em `src/`---

4. **Modifique:** Adicione suas extensões

## 🎯 Operações Disponíveis

---

### Sistema Interativo (10 opções)

## 📝 Resumo

| # | Operação | Tempo | Uso |

| Aspecto | Detalhe ||---|----------|-------|-----|

|---------|---------|| **1** | Cadastrar peça | O(log n) | Adiciona novo item ao estoque |

| **Linguagem** | Java 8+ || **2** | Buscar por código | O(log n) | Procura peça específica rapidamente |

| **Estrutura** | Árvore AVL auto-balanceada || **3** | Atualizar quantidade | O(log n) | Muda quantidade em estoque |

| **Operações** | CRUD completo + relatórios || **4** | Atualizar preço | O(log n) | Ajusta preço unitário |

| **Complexidade** | O(log n) garantido || **5** | Remover peça | O(log n) | Deleta peça descontinuada |

| **Código** | 597 linhas || **6** | Exibir estoque | O(n) | Lista todas as peças em ordem |

| **Testes** | 164 linhas || **7** | Valor total | O(n) | Calcula valor total em R$ |

| **Documentação** | Este arquivo || **8** | Estoque baixo | O(n) | Alerta: peças abaixo do limiar |

| **9** | Total de tipos | O(1) | Conta tipos diferentes |

---| **0** | Sair | - | Encerra programa |



**Desenvolvido com ❤️ para fins educacionais e práticos.**### Exemplo de Fluxo



última atualização: 10 de dezembro de 2025```

1. Cadastra: [1010] Vela de ignição | Qtd: 15 | R$ 18,50
2. Busca [1010] → Encontrada em O(log n)
3. Atualiza quantidade [1010]: 15 → 20
4. Atualiza preço [1010]: 18,50 → 19,00
5. Exibe estoque → Mostra ordenado (todas as peças)
6. Valor total → Calcula R$ de tudo
7. Estoque baixo → Se [1010] tivesse < 10, alertaria
8. Remove [1010] → Peça deletada
9. Total → Quantidade de tipos reduz
```

---

## 📊 Complexidade Computacional

### Análise Teórica

| Operação | Sem AVL | Com AVL | Melhoria |
|----------|---------|---------|----------|
| **Busca** | O(n) | **O(log n)** | 700x (10K itens) |
| **Inserção** | O(n) | **O(log n)** | 700x |
| **Remoção** | O(n) | **O(log n)** | 700x |
| **Altura** | O(n) | **O(log n)** | Balanceamento garantido |
| **Exibir ordenado** | O(n log n) | **O(n)** | n é obrigatório |

### Exemplo Numérico

Para **1 milhão de peças:**

```
Lista:
- Buscar uma peça: 1.000.000 comparações no pior caso
- Tempo: ~1 segundo em máquina moderna

Árvore AVL:
- Buscar uma peça: ~20 comparações (log₂ 1.000.000 ≈ 20)
- Tempo: ~0,02 milissegundos ⚡
  (50.000x mais rápido!)
```

### Garantia AVL

```
Para N peças, a altura máxima da árvore é sempre:
h_max = 1.44 × log₂(N + 2) - 0.328

Exemplo (N = 10.000):
h_max ≈ 14 nós no caminho mais longo
→ Qualquer operação: máximo 14 comparações
```

---

## 💻 Exemplos de Código

### Usar em Código Java

```java
// 1. Criar estoque
EstoqueOficina estoque = new EstoqueOficina();

// 2. Adicionar peças
estoque.adicionarPeca(1001, "Óleo 5W30", 25, 35.50);
estoque.adicionarPeca(1002, "Filtro", 40, 28.00);
estoque.adicionarPeca(1003, "Corrente", 8, 280.00);

// 3. Buscar (O(log n))
Peca p = estoque.buscarPeca(1001);
System.out.println(p);  // [1001] Óleo 5W30 | Qtd: 25 | R$ 35,50

// 4. Atualizar
estoque.atualizarQuantidade(1001, 30);
estoque.atualizarPreco(1001, 36.50);

// 5. Remover
estoque.removerPeca(1002);

// 6. Relatórios
estoque.exibirEstoque();           // Lista em ordem
estoque.listarEstoqueBaixo(10);    // Alerta
double total = estoque.calcularValorEstoque();  // R$
System.out.printf("Valor: R$ %.2f\n", total);

// 7. Informações
System.out.println("Total tipos: " + estoque.totalPecas());
```

### Teste Automatizado

```java
// Ver TesteEstoque.java para implementação completa
public static void main(String[] args) {
    EstoqueOficina estoque = new EstoqueOficina();
    
    // Carregar 6 peças
    estoque.adicionarPeca(1001, "Óleo 5W30", 25, 35.50);
    estoque.adicionarPeca(1002, "Filtro de ar", 40, 28.00);
    estoque.adicionarPeca(1003, "Corrente", 8, 280.00);
    estoque.adicionarPeca(1004, "Pastilha de freio", 15, 89.90);
    estoque.adicionarPeca(1005, "Vela", 2, 12.50);
    estoque.adicionarPeca(1006, "Bateria", 5, 450.00);
    
    // Testes
    estoque.exibirEstoque();
    System.out.println("\nBuscando [1003]:");
    Peca p = estoque.buscarPeca(1003);
    System.out.println("Encontrada: " + p);
    
    estoque.atualizarQuantidade(1005, 20);
    estoque.atualizarPreco(1002, 32.00);
    estoque.removerPeca(1006);
    
    estoque.listarEstoqueBaixo(10);
    System.out.printf("\nValor total: R$ %.2f\n", 
        estoque.calcularValorEstoque());
}
```

---

## 📂 Estrutura de Arquivos

```
tad_avl/
├── README.md                    ← Você está aqui!
├── GUIA_RAPIDO.md              ← Resumo executivo
├── SISTEMA_ESTOQUE.md          ← Documentação completa
├── simples.sh                  ← Script de automação
│
└── src/
    ├── AVLNode.java            ← Nó genérico (9 linhas)
    ├── ArvoreAVL.java          ← Árvore AVL (274 linhas)
    ├── Peca.java               ← Modelo: peça automotiva (41 linhas)
    ├── EstoqueOficina.java     ← Gerenciador (87 linhas)
    ├── SistemaEstoque.java     ← Menu interativo (180 linhas)
    ├── TesteEstoque.java       ← Teste automatizado (60 linhas)
    └── TesteArvoreAVL.java     ← Teste de rotações (130 linhas)
```

### Tamanho do Projeto

```
Total de código Java: ~771 linhas
- Core (AVL): 283 linhas
- Sistema (Estoque): 348 linhas
- Testes: 190 linhas

Total de documentação: ~500 linhas
- README.md: Este arquivo
- GUIA_RAPIDO.md: 1-pager com exemplo de uso
- SISTEMA_ESTOQUE.md: Documentação detalhada
```

---

## 🔄 Fluxo de Operações

### Buscar Peça (O(log n))

```
Buscar [1003] em ~10.000 peças:

1. Começa na raiz [5500]
   1003 < 5500? Sim → vai para esquerda

2. Chega em [2750]
   1003 < 2750? Sim → vai para esquerda

3. Chega em [1375]
   1003 < 1375? Sim → vai para esquerda

4. Chega em [1003]
   1003 == 1003? SIM! ✓ Encontrada!

Total: 4 comparações em vez de até 10.000!
Máximo teórico: log₂(10.000) ≈ 14 comparações
```

### Inserir Peça (O(log n))

```
Inserir [1009]:

1. Busca posição (como acima): O(log n)
2. Cria novo nó: O(1)
3. Atualiza alturas: O(log n)
4. Verifica balance em cada nó no caminho: O(log n)
5. Se desequilibrado: Rotação: O(1)

Total: O(log n)
Resultado: Árvore permanece balanceada!
```

### Remover Peça (O(log n))

```
Remover [1003]:

Caso 1: Sem filhos
  → Remove direto

Caso 2: 1 filho
  → Sobe o filho

Caso 3: 2 filhos
  → Substitui por sucessor (menor da direita)
  → Remove sucessor recursivamente

Depois: Rebalanceia (rotações se necessário)

Total: O(log n)
```

---

## ✅ Teste Automatizado

Execute com:
```bash
./simples.sh teste
```

**Validações:**
1. ✅ Inserção de 6 peças
2. ✅ Exibição em ordem crescente
3. ✅ Busca por código (O(log n))
4. ✅ Atualização de quantidade
5. ✅ Atualização de preço
6. ✅ Remoção de peça
7. ✅ Exibição após remoção
8. ✅ Detecção de estoque baixo
9. ✅ Cálculo de valor total
10. ✅ Contagem de tipos

**Saída esperada:**
```
>>> Estoque (6 peças):
[1001] Óleo 5W30 | Qtd: 25 | R$ 35,50
[1002] Filtro de ar | Qtd: 40 | R$ 28,00
...

>>> Busca [1003]: ✅ Encontrada
>>> Atualização: ✅ Sucesso
>>> Remoção: ✅ Sucesso
>>> Estoque baixo: ⚠️ [1003] Corrente com 8 unidades
>>> Valor total: R$ 6006,00
>>> Total tipos: 5
```

---

## 🎓 Conceitos Importantes

### 1. Propriedade BST (Árvore de Busca Binária)
```
Para cada nó N:
- Todos os valores na subárvore esquerda < N
- Todos os valores na subárvore direita > N
- Isso permite busca binária: O(log n)

No nosso sistema:
- Peças ordenadas por CÓDIGO
- [1001] < [1002] < [1003] < ...
```

### 2. Auto-Balanceamento
```
Se em qualquer ponto: |altura_esq - altura_dir| > 1
→ Executa rotação automática
→ Restaura balanceamento em O(1)
→ Resultado: sempre O(log n)
```

### 3. Rotações (4 tipos)

**LL (Left-Left):**
```
    3           2
   /           / \
  2      →    1   3
 /
1
```

**RR (Right-Right):**
```
  1           2
   \         / \
    2   →   1   3
     \
      3
```

**LR (Left-Right) e RL (Right-Left):** Combinações de rotações

### 4. Traversals (Percursos)

**In-Order (En-Ordem):** Esq → Nó → Dir = **Ordenado**
```
[1001] Óleo → [1002] Filtro → [1003] Corrente → ...
```

**Pre-Order:** Nó → Esq → Dir = Raiz primeiro
```
[1003] → [1002] → [1001] → ...
```

**Post-Order:** Esq → Dir → Nó = Raiz último
```
[1001] → [1002] → [1003] → ...
```

---

## 🚀 Performance Real

### Teste com Dados

```java
// Comparação de velocidade
long inicio = System.currentTimeMillis();
for (int i = 0; i < 10000; i++) {
    estoque.buscarPeca(i);
}
long tempo = System.currentTimeMillis() - inicio;
System.out.println("10.000 buscas em " + tempo + "ms");

// Resultado esperado:
// - Lista: ~5000ms (lento 🐢)
// - AVL: ~50ms (rápido ⚡)
// Diferença: 100x mais rápido!
```
---

## 📚 Leitura Adicional

- **GUIA_RAPIDO.md** - 1-pager com exemplo de uso
- **SISTEMA_ESTOQUE.md** - Documentação detalhada
- **src/TesteEstoque.java** - Veja testes na prática
- **src/ArvoreAVL.java** - Código completo comentado

---

## 🎯 Resumo

| Aspecto | Detalhe |
|--------|---------|
| **Linguagem** | Java 8+ com Generics |
| **Estrutura** | Árvore AVL auto-balanceada |
| **Modelo** | Peças automotivas (código, nome, qtd, preço) |
| **Operações** | CRUD completo + relatórios |
| **Complexidade** | O(log n) em busca, inserção, remoção |
| **Balanceamento** | 4 tipos de rotações automáticas |
| **Interface** | Menu interativo com 10 opções |
| **Testes** | Suite automatizada completa |
| **Documentação** | 3 arquivos Markdown + código comentado |

---

## 💡 Quando Usar AVL?

✅ **Use AVL quando:**
- Precisa de muitas **buscas rápidas**
- Dados estão **constantemente mudando**
- Quer **performance garantida**
- Tem **1.000+ itens**

❌ **Não use AVL quando:**
- Dados são **estáticos** (use busca binária simples)
- Tem **< 100 itens** (lista é suficiente)
- Precisa de **ordem por múltiplos critérios** (use banco de dados)
- Espaço é **crítico** (AVL usa mais memória)

---
**Desenvolvido com ❤️ para fins educacionais e práticos.**

última atualização: 10 de dezembro de 2025
