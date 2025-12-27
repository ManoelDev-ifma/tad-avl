#!/usr/bin/env python3
import sys, csv
from collections import defaultdict
from statistics import mean, pstdev

input_csv = sys.argv[1] if len(sys.argv) > 1 else 'bench_fase_b_results.csv'
output_csv = sys.argv[2] if len(sys.argv) > 2 else 'bench_fase_b_summary.csv'

data = defaultdict(list)
ns = {}
ms = {}
with open(input_csv, newline='') as f:
    r = csv.DictReader(f)
    for row in r:
        estrutura = row['estrutura']
        n = int(row['n'])
        m = int(row['m'])
        altura = int(row['altura'])
        tempo = float(row['tempo_busca_ms'])
        data[estrutura].append((n,m,altura,tempo))
        ns[estrutura] = n
        ms[estrutura] = m

rows = []
for estrutura, items in data.items():
    tempos = [it[3] for it in items]
    alturas = [it[2] for it in items]
    avg_t = mean(tempos)
    std_t = pstdev(tempos) if len(tempos)>1 else 0.0
    avg_h = mean(alturas)
    std_h = pstdev(alturas) if len(alturas)>1 else 0.0
    rows.append((estrutura, ns[estrutura], ms[estrutura], len(items), avg_h, std_h, avg_t, std_t))

with open(output_csv, 'w', newline='') as f:
    w = csv.writer(f)
    w.writerow(['estrutura','n','m','repeticoes','avg_altura','std_altura','avg_tempo_ms','std_tempo_ms'])
    for r in rows:
        w.writerow(r)

with open(output_csv) as f:
    print(f.read())
