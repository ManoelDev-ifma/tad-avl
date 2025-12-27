#!/usr/bin/env bash
# Script para rodar o Benchmark Fase A várias vezes e salvar CSV
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "$0")" && pwd)"
OUT_DIR="$ROOT_DIR/out"
MAIN_CLASS="tad_rb.bench.BenchmarkFaseA"

N=${1:-100000}
REPS=${2:-5}
OUTCSV=${3:-"$ROOT_DIR/bench_fase_a_results.csv"}

echo "Preparando benchmark: N=$N, reps=$REPS, saída=$OUTCSV"

# Compila uma vez (recursivo)
mkdir -p "$OUT_DIR"
javac -d "$OUT_DIR" $(find "$ROOT_DIR/src" -name "*.java")

# Cabeçalho CSV
if [ ! -f "$OUTCSV" ]; then
  echo "repeticao,n,estrutura,tempo_ms,rot_esq,rot_dir" > "$OUTCSV"
fi

for i in $(seq 1 $REPS); do
  echo "Execução $i/$REPS..."
  # executa e captura a saída
  out=$(java -cp "$OUT_DIR" $MAIN_CLASS $N)
  # extrai blocos com grep
  # Exemplo de saída esperada (em português):
  # AVL: tempo=76 ms, rot-esq=34750, rot-dir=34831
  # Rubro-Negra: tempo=85 ms, rot-esq=29023, rot-dir=29079

  avl_line=$(echo "$out" | grep -E "^AVL:") || true
  rb_line=$(echo "$out" | grep -E "^Rubro-Negra:") || true

  if [ -n "$avl_line" ]; then
    # extrai números
    avl_tempo=$(echo "$avl_line" | sed -E 's/.*tempo=([0-9]+) ms.*/\1/')
    avl_re=$(echo "$avl_line" | sed -E 's/.*rot-esq=([0-9]+).*/\1/')
    avl_rd=$(echo "$avl_line" | sed -E 's/.*rot-dir=([0-9]+).*/\1/')
    echo "$i,$N,AVL,$avl_tempo,$avl_re,$avl_rd" >> "$OUTCSV"
  fi

  if [ -n "$rb_line" ]; then
    rb_tempo=$(echo "$rb_line" | sed -E 's/.*tempo=([0-9]+) ms.*/\1/')
    rb_re=$(echo "$rb_line" | sed -E 's/.*rot-esq=([0-9]+).*/\1/')
    rb_rd=$(echo "$rb_line" | sed -E 's/.*rot-dir=([0-9]+).*/\1/')
    echo "$i,$N,Rubro-Negra,$rb_tempo,$rb_re,$rb_rd" >> "$OUTCSV"
  fi

done

echo "Resultados gravados em $OUTCSV"
