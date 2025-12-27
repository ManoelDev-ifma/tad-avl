#!/usr/bin/env python3
import sys,csv
from collections import defaultdict
from statistics import mean,pstdev

input_csv = sys.argv[1] if len(sys.argv)>1 else 'bench_fase_c_results.csv'
output_csv = sys.argv[2] if len(sys.argv)>2 else 'bench_fase_c_summary.csv'

data = defaultdict(list)
ns = {}
rem = {}
with open(input_csv,newline='') as f:
    r = csv.DictReader(f)
    for row in r:
        estrutura = row['estrutura']
        n = int(row['n'])
        removidos = int(row['removidos'])
        tempo = float(row['tempo_remocao_ms'])
        re = float(row['rot_esq'])
        rd = float(row['rot_dir'])
        altura = float(row['altura'])
        data[estrutura].append((n,removidos,tempo,re,rd,altura))
        ns[estrutura]=n
        rem[estrutura]=removidos

rows=[]
for est,items in data.items():
    tempos=[it[2] for it in items]
    res=[it[3] for it in items]
    rds=[it[4] for it in items]
    alts=[it[5] for it in items]
    rows.append((est, ns[est], rem[est], len(items), mean(tempos), pstdev(tempos) if len(tempos)>1 else 0.0, mean(res), pstdev(res) if len(res)>1 else 0.0, mean(rds), pstdev(rds) if len(rds)>1 else 0.0, mean(alts), pstdev(alts) if len(alts)>1 else 0.0))

with open(output_csv,'w',newline='') as f:
    w=csv.writer(f)
    w.writerow(['estrutura','n','removidos','repeticoes','avg_tempo_ms','std_tempo_ms','avg_rot_esq','std_rot_esq','avg_rot_dir','std_rot_dir','avg_altura','std_altura'])
    for r in rows:
        w.writerow(r)

with open(output_csv) as f:
    print(f.read())
