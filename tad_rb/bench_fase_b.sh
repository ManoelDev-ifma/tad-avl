#!/usr/bin/env bash
# Executa Benchmark Fase B várias vezes e grava CSV
set -euo pipefail
ROOT_DIR="$(cd "$(dirname "$0")" && pwd)"
OUT_DIR="$ROOT_DIR/out"
MAIN_CLASS="tad_rb.bench.BenchmarkFaseB"

N=${1:-100000}
M=${2:-100000}
REPS=${3:-5}
OUTCSV=${4:-"$ROOT_DIR/bench_fase_b_results.csv"}

echo "Preparando Fase B: N=$N, M=$M, reps=$REPS, saída=$OUTCSV"

mkdir -p "$OUT_DIR"
javac -d "$OUT_DIR" $(find "$ROOT_DIR/src" -name "*.java")

if [ ! -f "$OUTCSV" ]; then
  echo "repeticao,n,m,estrutura,altura,tempo_busca_ms" > "$OUTCSV"
fi

for i in $(seq 1 $REPS); do
  echo "Execução $i/$REPS..."
  out=$(java -cp "$OUT_DIR" $MAIN_CLASS $N $M)
  avl_line=$(echo "$out" | grep -E "^AVL:") || true
  rb_line=$(echo "$out" | grep -E "^Rubro-Negra:") || true
  if [ -n "$avl_line" ]; then
    avl_alt=$(echo "$avl_line" | sed -E 's/.*altura=([0-9]+).*/\1/')
    avl_t=$(echo "$avl_line" | sed -E 's/.*tempo_busca_total=([0-9]+) ms.*/\1/')
    echo "$i,$N,$M,AVL,$avl_alt,$avl_t" >> "$OUTCSV"
  fi
  if [ -n "$rb_line" ]; then
    rb_alt=$(echo "$rb_line" | sed -E 's/.*altura=([0-9]+).*/\1/')
    rb_t=$(echo "$rb_line" | sed -E 's/.*tempo_busca_total=([0-9]+) ms.*/\1/')
    echo "$i,$N,$M,Rubro-Negra,$rb_alt,$rb_t" >> "$OUTCSV"
  fi
done

echo "Resultados Fase B gravados em $OUTCSV"
