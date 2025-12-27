#!/usr/bin/env bash
# Executa Benchmark Fase C várias vezes e grava CSV
set -euo pipefail
ROOT_DIR="$(cd "$(dirname "$0")" && pwd)"
OUT_DIR="$ROOT_DIR/out"
MAIN_CLASS="tad_rb.bench.BenchmarkFaseC"

N=${1:-100000}
REM=${2:--1}
REPS=${3:-5}
OUTCSV=${4:-"$ROOT_DIR/bench_fase_c_results.csv"}

echo "Preparando Fase C: N=$N, removidos=$REM (se -1 -> 10%), reps=$REPS, saída=$OUTCSV"

mkdir -p "$OUT_DIR"
javac -d "$OUT_DIR" $(find "$ROOT_DIR/src" -name "*.java")

if [ ! -f "$OUTCSV" ]; then
  echo "repeticao,n,removidos,estrutura,tempo_remocao_ms,rot_esq,rot_dir,altura" > "$OUTCSV"
fi

for i in $(seq 1 $REPS); do
  echo "Execução $i/$REPS..."
  out=$(java -cp "$OUT_DIR" $MAIN_CLASS $N $REM)
  avl_line=$(echo "$out" | grep -E "^AVL:") || true
  rb_line=$(echo "$out" | grep -E "^Rubro-Negra:") || true
  if [ -n "$avl_line" ]; then
    avl_t=$(echo "$avl_line" | sed -E 's/.*tempo_remocao_ms=([0-9]+).*/\1/')
    avl_re=$(echo "$avl_line" | sed -E 's/.*rot-esq=([0-9]+).*/\1/')
    avl_rd=$(echo "$avl_line" | sed -E 's/.*rot-dir=([0-9]+).*/\1/')
    avl_alt=$(echo "$avl_line" | sed -E 's/.*altura=([0-9]+).*/\1/')
    echo "$i,$N,$REM,AVL,$avl_t,$avl_re,$avl_rd,$avl_alt" >> "$OUTCSV"
  fi
  if [ -n "$rb_line" ]; then
    rb_t=$(echo "$rb_line" | sed -E 's/.*tempo_remocao_ms=([0-9]+).*/\1/')
    rb_re=$(echo "$rb_line" | sed -E 's/.*rot-esq=([0-9]+).*/\1/')
    rb_rd=$(echo "$rb_line" | sed -E 's/.*rot-dir=([0-9]+).*/\1/')
    rb_alt=$(echo "$rb_line" | sed -E 's/.*altura=([0-9]+).*/\1/')
    echo "$i,$N,$REM,Rubro-Negra,$rb_t,$rb_re,$rb_rd,$rb_alt" >> "$OUTCSV"
  fi
done

echo "Resultados Fase C gravados em $OUTCSV"
