#!/bin/bash

# Script simples para Árvore AVL
# Uso: ./simples.sh [teste|exemplo|limpar]

echo "╔════════════════════════════════╗"
echo "║   ÁRVORE AVL - Versão Simples  ║"
echo "╚════════════════════════════════╝"
echo ""

cd src

case "$1" in
    teste)
        echo "🧪 Compilando e testando..."
        javac AVLNode.java ArvoreAVL.java TesteArvoreAVL.java && java TesteArvoreAVL
        ;;
    limpar)
        echo "🧹 Limpando arquivos .class..."
        rm -f *.class
        echo "✅ Pronto!"
        ;;
    *)
        echo "📦 Compilando..."
        javac AVLNode.java ArvoreAVL.java TesteArvoreAVL.java
        if [ $? -eq 0 ]; then
            echo "✅ Compilação OK!"
            echo ""
            echo "Execute:"
            echo "  ./simples.sh teste   - Rodar testes"
            echo "  ./simples.sh limpar  - Limpar .class"
        else
            echo "❌ Erro na compilação!"
        fi
        ;;
esac

cd ..
