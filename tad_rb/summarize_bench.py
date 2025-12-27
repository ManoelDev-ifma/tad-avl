#!/usr/bin/env python3
"""Gera resumo estatístico do benchmark Fase A.
Uso: python3 summarize_bench.py [input_csv] [output_csv]
"""
import sys
import csv
from collections import defaultdict
from statistics import mean, pstdev

input_csv = sys.argv[1] if len(sys.argv) > 1 else 'bench_fase_a_results.csv'
output_csv = sys.argv[2] if len(sys.argv) > 2 else 'bench_fase_a_summary.csv'

data = defaultdict(list)
ns = {}

with open(input_csv, newline='') as f:
    reader = csv.DictReader(f)
    for row in reader:
        estrutura = row['estrutura']
        n = int(row['n'])
        tempo = float(row['tempo_ms'])
        rot_e = float(row['rot_esq'])
        rot_d = float(row['rot_dir'])
        data[estrutura].append((n, tempo, rot_e, rot_d))
        ns[estrutura] = n

# compute stats
rows = []
for estrutura, items in data.items():
    tempos = [it[1] for it in items]
    re = [it[2] for it in items]
    rd = [it[3] for it in items]
    avg_t = mean(tempos)
    std_t = pstdev(tempos) if len(tempos) > 1 else 0.0
    avg_re = mean(re)
    std_re = pstdev(re) if len(re) > 1 else 0.0
    avg_rd = mean(rd)
    std_rd = pstdev(rd) if len(rd) > 1 else 0.0
    rows.append((estrutura, ns.get(estrutura, ''), len(items), avg_t, std_t, avg_re, std_re, avg_rd, std_rd))

# write summary CSV
with open(output_csv, 'w', newline='') as f:
    writer = csv.writer(f)
    writer.writerow(['estrutura','n','repeticoes','avg_tempo_ms','std_tempo_ms','avg_rot_esq','std_rot_esq','avg_rot_dir','std_rot_dir'])
    for r in rows:
        writer.writerow(r)

# print result
with open(output_csv) as f:
    print(f.read())
