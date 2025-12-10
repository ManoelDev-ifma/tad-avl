#!/bin/bash

# Script para Sistema de Estoque com Árvore AVL
# Uso: ./simples.sh [teste|sistema|limpar]

echo "╔════════════════════════════════════════════════════╗"
echo "║   SISTEMA DE ESTOQUE - Árvore AVL                  ║"
echo "╚════════════════════════════════════════════════════╝"
echo ""

cd src

case "$1" in
    teste)
        echo "🧪 Compilando e executando testes..."
        javac AVLNode.java ArvoreAVL.java Peca.java EstoqueOficina.java TesteEstoque.java && java TesteEstoque
        ;;
    sistema)
        echo "🏪 Iniciando sistema interativo de estoque..."
        javac AVLNode.java ArvoreAVL.java Peca.java EstoqueOficina.java SistemaEstoque.java && java SistemaEstoque
        ;;
    limpar)
        echo "🧹 Limpando arquivos .class..."
        rm -f *.class
        echo "✅ Pronto!"
        ;;
    *)
        echo "📦 Compilando sistema..."
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
        ;;
esac

cd ..
