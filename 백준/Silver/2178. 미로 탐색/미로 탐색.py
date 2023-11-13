from collections import deque
import sys
input = sys.stdin.readline
my_que = deque()
N, M = map(int, input().split())
visited = [[False] * M for _ in range(N)] 

matrix = [list(map(int, input().strip())) for _ in range(N)]
dx = [0, 1, -1, 0]
dy = [1, 0, 0, -1]

def BFS(x, y, count):
    my_que.append((x, y, count))
    visited[x][y] = True

    while my_que:
        ax, ay, count = my_que.popleft()

        if ax == N - 1 and ay == M - 1:
            return count

        for i in range(4):
            nx, ny = ax + dx[i], ay + dy[i]
            if 0 <= nx < N and 0 <= ny < M and matrix[nx][ny] == 1 and not visited[nx][ny]:
                my_que.append((nx, ny, count + 1))
                visited[nx][ny] = True  # 큐에 새로운 정보를 추가할 때에만 visited를 설정하도록 변경

my_count = BFS(0, 0, 1)
print(my_count)
