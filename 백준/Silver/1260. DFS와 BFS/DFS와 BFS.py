from collections import deque

def BFS(V):
    q = deque([V]) 
    visited2[V] = True  # 첫 시작점은 방문 True로 초기화
    while q:  
        V = q.popleft()  
        print(V, end=" ") 
        for i in range(1, N + 1):  
            if not visited2[i] and graph[V][i]:  # 방문 했던 곳이 아니고, V 값과 연결되어 있는지
                q.append(i) 
                visited2[i] = True  # 방문(True)으로 초기화


def DFS(V):
    visited1[V] = True 
    print(V, end=" ")
    for i in range(1, N + 1):
        if not visited1[i] and graph[V][i]:  # 방문 했던 곳이 아니고, V 값과 연결되어 있는지
            DFS(i)  # 재귀 호출을 이용하여 깊은 탐색

N, M, V = map(int, input().split())

graph = [[False] * (N + 1) for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a][b] = True
    graph[b][a] = True

visited1 = [False] * (N + 1)  # DFS 방문 유무
visited2 = [False] * (N + 1)  # BFS 방문 유무

DFS(V)
print()
BFS(V)