import sys
from collections import deque
input = sys.stdin.readline()

def BFS():
    q = deque()
    q.append(N)
    while q:
        x = q.popleft()
        if x == K:
            print(visited[x])
            break
        for i in (x-1, x+1, x*2):
            if 0 <= i <= max and not visited[i]:
                visited[i] = visited[x] + 1
                q.append(i) 
    


max = 100000
N, K = map(int, input.split())
visited = [0] * (max + 1)
BFS()