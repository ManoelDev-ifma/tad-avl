#!/usr/bin/env bash
# Limpa saída e executa o teste Main
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "$0")" && pwd)"
OUT_DIR="$ROOT_DIR/out"

usage() {
		cat <<EOF
Uso: $0 [comando]

Comandos:
	delete    Remove o diretório de classes compiladas
	test      Compila (se necessário) e executa o teste
	all       Remove, compila e executa (padrão)
	help      Mostra ajuda
EOF
}

cmd=${1:-all}

if [ "$cmd" = "help" ]; then
	usage
	exit 0
fi

if [ "$cmd" = "delete" ] || [ "$cmd" = "all" ]; then
	echo "Limpando diretório de saída..."
	rm -rf "$OUT_DIR"
	echo "Removido $OUT_DIR"
	if [ "$cmd" = "delete" ]; then
		exit 0
	fi
fi

if [ "$cmd" = "test" ] || [ "$cmd" = "all" ]; then
	echo "Compilando..."
	mkdir -p "$OUT_DIR"
	# compila recursivamente todos os fontes Java
	javac -d "$OUT_DIR" $(find "$ROOT_DIR/src" -name "*.java")

	echo "Executando teste (tad_rb.rb.Main)..."
	java -cp "$OUT_DIR" tad_rb.rb.Main

	echo "Concluído."
	exit 0
fi

echo "Comando desconhecido: $cmd" >&2
usage
exit 2
