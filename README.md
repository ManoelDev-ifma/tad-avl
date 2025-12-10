# 🌳 Árvore AVL - Sistema de Estoque para Oficina Mecânica# Árvore AVL em Português



Implementação completa de uma **Árvore AVL** (Árvore Binária de Busca Auto-Balanceada) em Java com aplicação prática: sistema de gestão de estoque de peças automotivas.Implementação de uma Árvore AVL (Árvore Binária de Busca Auto-Balanceada) em Java com Generics.

1. [O que é Árvore AVL?](#o-que-é-árvore-avl)## Aplicação Real: Sistema de Estoque para Oficina Mecânica

2. [Por que Árvore AVL?](#por-que-árvore-avl)

3. [Aplicação Real](#-aplicação-real-sistema-de-estoque)O projeto implementa um sistema prático de gestão de estoque de peças automotivas:

4. [Início Rápido](#-início-rápido)

5. [Como Usar](#como-usar)- **Cadastro de peças** com código, nome, quantidade e preço

6. [Componentes](#-componentes)- **Buscas rápidas** por código de peça

7. [Operações Disponíveis](#-operações-disponíveis)- **Atualizações** de quantidade e preço

8. [Complexidade](#-complexidade-computacional)- **Remoção** de peças descontinuadas

9. [Exemplos de Código](#-exemplos-de-código)- **Relatório de estoque** em ordem crescente

10. [Estrutura de Arquivos](#-estrutura-de-arquivos)- **Alerta de estoque baixo** com limite configurável

- **Valor total** do estoque em tempo real

---

### Por que AVL?

## O que é Árvore AVL?

Lista encadeada: buscar entre milhares de peças = **O(n)** lento  

Uma **Árvore AVL** é uma Árvore Binária de Busca que se **auto-balancea** automaticamente. Árvore AVL: buscar = **O(log n)** rápido  

Diferença real: 10.000 peças = 10.000 comparações vs. 14 comparações!

**Propriedade AVL:** `|altura_esquerda - altura_direita| ≤ 1`

## Como Usar

Isso significa que em qualquer nó da árvore, a diferença entre as alturas das subárvores esquerda e direita é no máximo 1.

Árvore AVL balanceada (3 peças):### Executar Teste

           [1003]```bash

          /      \java TesteEstoque

       [1002]    [1005]```

       /

    [1001]### Sistema Interativo

```bash

✅ Balanceamento OK:javac SistemaEstoque.java

   - Nó raiz: |1 - 2| = 1 ✓java SistemaEstoque

   - Nó esquerdo: |1 - 0| = 1 ✓```

   - Nó direito: |0 - 0| = 0 ✓

```### Usando o Script

```bash

---./simples.sh         # Compilar

./simples.sh teste   # Executar testes

## Por que Árvore AVL?./simples.sh sistema # Sistema interativo

./simples.sh limpar  # Limpar .class

### Comparação de Performance```



Imagine uma oficina com **10.000 peças** diferentes:## Exemplo de Código



| Estrutura | Buscar | Inserir | Remover | Melhor Para |```java

|-----------|--------|---------|---------|-------------|// Criar árvore de inteiros

| **Array** | O(n) = 10.000 passos 🐢 | O(n) | O(n) | Dados fixos |ArvoreAVL<Integer> arvore = new ArvoreAVL<>();

| **Lista Encadeada** | O(n) = 10.000 passos 🐢 | O(n) | O(n) | Dados pequenos |

| **Árvore AVL** | O(log n) = 14 passos ⚡ | O(log n) = 14 passos | O(log n) = 14 passos | **Dados dinâmicos grandes** |// Inserir elementos

arvore.inserir(50);

**Diferença Real:** AVL é **~700x mais rápido** para 10.000 itens! 🚀arvore.inserir(30);

arvore.inserir(70);

### Exemplo Práticoarvore.inserir(20);

arvore.inserir(40);

```

Buscar código [1003] entre 10.000 peças:// Buscar

boolean encontrou = arvore.buscar(30);  // true

❌ SEM AVL (Lista):

   Comparação 1: É [1001]? Não...// Informações

   Comparação 2: É [1002]? Não...System.out.println("Tamanho: " + arvore.tamanho());      // 5

   ...System.out.println("Altura: " + arvore.altura());        // 3

   Comparação 3: É [1003]? SIM! ✓System.out.println("Mínimo: " + arvore.minimo());        // 20

   (No pior caso: 10.000 comparações!)System.out.println("Máximo: " + arvore.maximo());        // 70



✅ COM AVL:// Visualizar

   Comparação 1: [1003] > [5500]? Sim, vai direitaarvore.exibir();    // Mostra estrutura visual

   Comparação 2: [1003] < [7500]? Sim, vai esquerdaarvore.emOrdem();   // 20 30 40 50 70

   Comparação 3: [1003] encontrada! ✓

   (Máximo de comparações: ~14)// Remover

```arvore.remover(30);



---// Limpar

arvore.limpar();

## 🏪 Aplicação Real: Sistema de Estoque```



### O Problema## Métodos Disponíveis


P
Uma oficina mecânica precisa gerenciar milhares de peças:### Operações Básicas

- Óleo, filtros, pastilhas, correntes, velas, baterias...- `inserir(dado)` - Insere elemento na árvore

- Cada peça tem: código, nome, quantidade, preço- `remover(dado)` - Remove elemento da árvore

- Precisa de: buscas rápidas, atualizações, alertas de estoque baixo, cálculos de valor total- `buscar(dado)` - Busca um elemento (retorna boolean)

- `minimo()` - Retorna o menor elemento

### A Solução- `maximo()` - Retorna o maior elemento



**Árvore AVL com modelo de dados específico (Peca):**### Informações

- `tamanho()` - Número de elementos na árvore

```java- `altura()` - Altura da árvore

class Peca implements Comparable<Peca> {- `vazia()` - Verifica se a árvore está vazia

    int codigo;      // Chave: 1001, 1002, 1003...- `limpar()` - Remove todos os elementos

    String nome;     // "Óleo 5W30", "Filtro"...

    int quantidade;  // Unidades em estoque### Percursos

    double preco;    // Preço unitário- `emOrdem()` - Percurso em ordem (esquerda → raiz → direita)

}- `preOrdem()` - Percurso pré-ordem (raiz → esquerda → direita)

```- `posOrdem()` - Percurso pós-ordem (esquerda → direita → raiz)



### Funcionalidades### Visualização

- `exibir()` - Exibe a árvore com altura (h) e fator de balanceamento (fb)

✅ **Cadastro de peças** - Adicionar nova peça ao estoque  

✅ **Busca por código** - O(log n), mesmo com milhares  ## Estrutura dos Arquivos

✅ **Atualizar quantidade** - Repor ou usar estoque  

✅ **Atualizar preço** - Ajustar valores  ```

✅ **Remover peça** - Descontinuar item  tad_avl/

✅ **Exibir estoque** - Lista ordenada por código  ├── src/

✅ **Alerta de estoque baixo** - Detecta peças críticas  │   ├── AVLNode.java          # Estrutura do nó

✅ **Valor total** - Calcula R$ do inventário todo  │   ├── ArvoreAVL.java        # Implementação da árvore

✅ **Contador de tipos** - Quantos tipos diferentes  │   └── TesteArvoreAVL.java   # Testes

├── simples.sh                # Script de compilação

### Dados Pré-Carregados (8 peças)├── .gitignore                # Arquivos ignorados

└── README.md                 # Este arquivo

``````

[1001] Óleo 5W30          | Qtd: 25  | R$ 35,50

[1002] Filtro de ar       | Qtd: 40  | R$ 28,00## Rotações Implementadas

[1003] Corrente           | Qtd: 8   | R$ 280,00  ⚠️ BAIXO

[1004] Pastilha de freio  | Qtd: 15  | R$ 89,90A árvore implementa as 4 rotações necessárias para manter o balanceamento:

[1005] Vela               | Qtd: 2   | R$ 12,50   ⚠️ CRÍTICO

[1006] Bateria            | Qtd: 5   | R$ 450,001. **Rotação Direita (LL)** - Quando desbalanceia à esquerda-esquerda

[1007] Correia            | Qtd: 3   | R$ 65,002. **Rotação Esquerda (RR)** - Quando desbalanceia à direita-direita  

[1008] Radiador           | Qtd: 2   | R$ 320,003. **Rotação Dupla Direita (LR)** - Quando desbalanceia esquerda-direita

```4. **Rotação Dupla Esquerda (RL)** - Quando desbalanceia direita-esquerda



---## Complexidade



## ⚡ Início RápidoTodas as operações principais têm complexidade **O(log n)**:

- Inserção: O(log n)

### 1️⃣ Compilar- Remoção: O(log n)

```bash- Busca: O(log n)

./simples.sh- Mínimo/Máximo: O(log n)

```

## Exemplo de Saída

### 2️⃣ Executar Testes

```bash```

./simples.sh teste🌳 Árvore:

```└── 50 (h:3, fb:0)

    ├── 30 (h:2, fb:0)

Saída esperada:    │   ├── 20 (h:1, fb:0)

```    │   └── 40 (h:1, fb:0)

✅ Carrega 6 peças    └── 70 (h:2, fb:0)

✅ Exibe estoque em ordem        ├── 60 (h:1, fb:0)

✅ Busca peça por código        └── 80 (h:1, fb:0)

✅ Atualiza quantidade

✅ Atualiza preçoEm ordem: 20 30 40 50 60 70 80

✅ Remove peça```

✅ Lista estoque baixo

✅ Calcula valor totalOnde:

```- **h** = altura do nó

- **fb** = fator de balanceamento (altura_esq - altura_dir)

### 3️⃣ Sistema Interativo

```bash## Funciona com Generics

./simples.sh sistema

```A árvore funciona com qualquer tipo que implemente `Comparable`:


### Opção 3: Script Automatizado (Recomendado)

```bash
# Compilar
./simples.sh

# Testes
./simples.sh teste

# Sistema interativo
./simples.sh sistema

# Limpar .class
./simples.sh limpar
```

---

## 🔧 Componentes

### 1. `AVLNode.java` (9 linhas)
**Nó genérico da árvore**

```java
public class AVLNode<T extends Comparable<T>> {
    public T dado;
    public AVLNode<T> esquerda, direita;
    public int altura;
}
```

### 2. `ArvoreAVL.java` (274 linhas)
**Implementação completa da Árvore AVL**

**Operações principais (todas O(log n)):**
- `inserir(T dado)` - Insere mantendo balanceamento
- `remover(T dado)` - Remove e rebalanceia
- `buscar(T dado)` - Busca rápida por comparação
- `minimo()` / `maximo()` - Extremos
- `altura()` - Altura da árvore
- `vazia()` - Verifica se vazia
- `tamanho()` - Quantidade de nós
- `limpar()` - Esvazia a árvore
- `emOrdem()` / `preOrdem()` / `posOrdem()` - Traversals

**Rotações (balanceamento):**
- LL (Left-Left): Rotação direita simples
- RR (Right-Right): Rotação esquerda simples
- LR (Left-Right): Rotação dupla
- RL (Right-Left): Rotação dupla

**Método especial:**
- `obterRaiz()` - Acesso ao nó raiz para operações customizadas

### 3. `Peca.java` (41 linhas)
**Modelo de dados: Peça Automotiva**

```java
class Peca implements Comparable<Peca> {
    int codigo;      // Chave de ordenação (1001, 1002...)
    String nome;     // Nome descritivo
    int quantidade;  // Unidades em estoque
    double preco;    // Preço unitário
    
    // toString(): "[1001] Óleo 5W30 | Qtd: 25 | R$ 35,50"
    // compareTo(): Usa código para ordenação
}
```

**Propriedade importante:** Implementa `Comparable<Peca>` usando `codigo` como chave. Isso mantém a propriedade BST (Árvore de Busca Binária): peças sempre ordenadas por código.

### 4. `EstoqueOficina.java` (87 linhas)
**Gerenciador de Estoque (Lógica de Negócio)**

```java
class EstoqueOficina {
    // CRUD Básico
    void adicionarPeca(int cod, String nome, int qtd, double preco)
    Peca buscarPeca(int codigo)           // O(log n)
    void atualizarQuantidade(int cod, int novaQtd)
    void atualizarPreco(int cod, double novoPreco)
    void removerPeca(int codigo)
    
    // Relatórios
    void exibirEstoque()                  // In-order
    void listarEstoqueBaixo(int limiteMin)
    double calcularValorEstoque()         // Soma recursiva
    int totalPecas()
    
    // Helpers (recursivos)
    private Peca buscaComCodigo(AVLNode<Peca> nó, int codigo)
    private void exibirRec(AVLNode<Peca> nó)
    private void listarBaixoRec(AVLNode<Peca> nó, int limite)
    private double calcularValorRec(AVLNode<Peca> nó)
}
```

**Design Pattern:** Wrapper que encapsula a árvore e adiciona lógica de domínio.

### 5. `SistemaEstoque.java` (180 linhas)
**Interface Interativa (Menu de 10 Operações)**

```java
class SistemaEstoque {
    void iniciar()              // Loop principal
    void exibirMenu()           // Mostra opções
    void procesarOpcao(int op)  // Roteia para operação
    void cadastrarPeca()        // Op. 1
    void buscarPeca()           // Op. 2
    void atualizarQuantidade()  // Op. 3
    void atualizarPreco()       // Op. 4
    void removerPeca()          // Op. 5
    void exibirEstoque()        // Op. 6
    void valorTotal()           // Op. 7
    void listarEstoqueBaixo()   // Op. 8
    void totalPecas()           // Op. 9
}
```

### 6. `TesteEstoque.java` (60 linhas)
**Teste Automatizado Completo**

Executa sequência de operações e valida:
- Carregamento de peças
- Exibição ordenada
- Buscas
- Atualizações
- Remoções
- Relatórios
- Cálculos

---

## 🎯 Operações Disponíveis

### Sistema Interativo (10 opções)

| # | Operação | Tempo | Uso |
|---|----------|-------|-----|
| **1** | Cadastrar peça | O(log n) | Adiciona novo item ao estoque |
| **2** | Buscar por código | O(log n) | Procura peça específica rapidamente |
| **3** | Atualizar quantidade | O(log n) | Muda quantidade em estoque |
| **4** | Atualizar preço | O(log n) | Ajusta preço unitário |
| **5** | Remover peça | O(log n) | Deleta peça descontinuada |
| **6** | Exibir estoque | O(n) | Lista todas as peças em ordem |
| **7** | Valor total | O(n) | Calcula valor total em R$ |
| **8** | Estoque baixo | O(n) | Alerta: peças abaixo do limiar |
| **9** | Total de tipos | O(1) | Conta tipos diferentes |
| **0** | Sair | - | Encerra programa |

### Exemplo de Fluxo

```
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
