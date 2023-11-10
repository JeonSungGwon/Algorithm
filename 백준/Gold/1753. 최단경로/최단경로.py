import sys
input = sys.stdin.readline
from queue import PriorityQueue  

V, E = map(int, input().split()) # V(노드 개수), E(간선 개수)
K = int(input()) # K(출발 노드)
distance = [sys.maxsize] * (V+1) # 거리 저장 리스트(충분히 큰 수로 초기화)
visited = [False] * (V+1) # 방문 여부 저장 리스트 (모두 False로 저장을 한다)
myList = [[] for _ in range(V+1)] # 에지 데이터 저장 인접 리스트 (2중 리스트)
q = PriorityQueue() # 다익스트라를 위한 우선순위 큐

for _ in range(E):
    u, v, w = map(int, input().split()) # u->v로 가는 가중치 w 간선
    myList[u].append((v, w)) # 이차원 리스트에 값 추가 

q.put((0, K)) # 가중치와 시작 노드 
distance[K] = 0 # 시작노드의 거리는 0으로 초기화

while q.qsize() > 0: 
    current = q.get() 
    c_v = current[1] # 1번이 현재 노드
    if visited[c_v]:
        continue
    visited[c_v] = True
    for tmp in myList[c_v]:
        next = tmp[0] # next v 노드
        vlaue = tmp[1] # v 노드로 가는 가중치 
        if distance[next] > distance[c_v] + vlaue: # next로 가는 가중치보다 현재 위치 가중치 + next 노드로 가는 가중치가 더 작으면
            distance[next] = distance[c_v] + vlaue # next 가중치 값 변경
            q.put((distance[next],next)) 

for i in range(1, V+1):
    if visited[i]:
        print(distance[i])
    else:
        print("INF")