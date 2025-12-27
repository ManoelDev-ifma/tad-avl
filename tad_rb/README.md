
# Árvore Rubro-Negra (TAD) - Implementação Genérica em Java

Implementação genérica de árvore rubro-negra com sentinel `Nil` único.

Arquivos principais:

- `src/RedBlackTree.java` — implementação genérica com verificação de integridade.
- `src/Main.java` — exemplo que insere, remove e mostra contadores de rotações.

Compilar e executar (na raiz do projeto):

```bash
javac -d out src/*.java
java -cp out tad_rb.Main
```

Script de teste:

Use `./exec.sh [comando]` para rotinas de limpeza/compilação/execução.

Comandos:

- `delete` — remove `out`.
- `test` — compila (se necessário) e executa.
- `all` (padrão) — remove, compila e executa.

Exemplos:

```bash
./exec.sh delete
./exec.sh test
./exec.sh all
```

Observações:

- As chaves devem implementar `Comparable<T>`.
- O sentinel `Nil` é sempre preto.
