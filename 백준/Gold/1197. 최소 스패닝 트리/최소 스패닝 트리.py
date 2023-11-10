import sys
input = sys.stdin.readline

N, M = map(int, input().split())
edges = []
parent = [0] * (N+1)

for i in range(N+1):
    parent[i] = i

for i in range(M):
    s, e, w = map(int, input().split())
    edges.append((s, e, w))
edges.sort(key=lambda x: x[2])

def find(a):
    if a == parent[a]:
        return a
    else:
        parent[a] = find(parent[a])
        return parent[a]
    
def union(a, b):
    a = find(a)
    b = find(b)
    if a != b:
        parent[b] = a

useEdge = 0 
result = 0

for s,e,w in edges:
    if useEdge == N-1:
        break
    if find(s) != find(e):
        union(s, e)
        result += w
        useEdge += 1

print(result)