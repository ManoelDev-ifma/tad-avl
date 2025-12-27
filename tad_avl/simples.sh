#!/bin/bash

# Script para Sistema de Estoque com Árvore AVL
# Uso: ./simples.sh [teste|sistema|limpar]

echo "╔════════════════════════════════════════════════════╗"
echo "║   SISTEMA DE ESTOQUE - Árvore AVL                  ║"
echo "╚════════════════════════════════════════════════════╝"
echo ""

case "$1" in
    teste)
        echo "🧪 Compilando e executando testes..."
        cd src
        javac AVLNode.java ArvoreAVL.java Peca.java EstoqueOficina.java
        cd ../test
        javac -cp ../src TesteEstoque.java TesteArvoreAVL.java && java -cp ../src:. TesteEstoque
        cd ..
        ;;
    sistema)
        echo "🏪 Iniciando sistema interativo de estoque..."
        cd src
        javac AVLNode.java ArvoreAVL.java Peca.java EstoqueOficina.java SistemaEstoque.java && java SistemaEstoque
        cd ..
        ;;
    limpar)
        echo "🧹 Limpando arquivos .class..."
        rm -f src/*.class test/*.class
        echo "✅ Pronto!"
        ;;
    *)
        echo "📦 Compilando sistema..."
        cd src
        javac AVLNode.java ArvoreAVL.java Peca.java EstoqueOficina.java
        if [ $? -eq 0 ]; then
            echo "✅ Compilação OK!"
            echo ""
            echo "Execute:"
            echo "  ./simples.sh teste   - Rodar testes automatizados"
            echo "  ./simples.sh sistema - Sistema interativo de estoque"
            echo "  ./simples.sh limpar  - Limpar .class"
        else
            echo "❌ Erro na compilação!"
        fi
        cd ..
        ;;
esac
