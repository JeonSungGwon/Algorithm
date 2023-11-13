import sys
matrix = [list(map(int,input())) for _ in range(4)]
visited = [False] * 4
count = 0
# 2 <-> 6  

K = int(input())

def DFS(N, way):
    global visited
    if N - 1 >= 0 and matrix[N][6] != matrix[N-1][2] and not visited[N-1]:
        visited[N] = True
        DFS(N-1, -way)
    if N + 1 < 4 and matrix[N][2] != matrix[N+1][6] and not visited[N+1]:
        visited[N] = True
        DFS(N+1, -way)

    if way == 1:
        temp =matrix[N][7]
        for i in range(7, 0, -1):
            matrix[N][i] = matrix[N][i-1]
        matrix[N][0] = temp
    if way == -1:
        temp = matrix[N][0]
        for i in range(0, 7):
            matrix[N][i] = matrix[N][i+1]
        matrix[N][7] = temp

for i in range(K):
    N, way = map(int, input().split())
    N = N-1
    DFS(N, way)
    visited = [False] * 4

for i in range(0,4):
    if matrix[i][0] == 1:
        count += 2 ** i

print(count)


