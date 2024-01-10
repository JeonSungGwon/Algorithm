from collections import deque

N = int(input())

board = [list(map(str, input())) for _ in range(N)]
visited = [[False] * N for _ in range(N)]
d = [(0, 1), (1, 0), (-1, 0), (0, -1)]
def BFS(x,y):
    q = deque()
    q.append((x,y))
    visited[x][y] = True

    while q:
        x, y = q.popleft()
        for dx, dy in d:
            nx, ny = x+dx, y+dy
            if 0 <= nx < N and 0 <= ny < N and board[nx][ny] == board[x][y] and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append((nx,ny))

cnt1=0
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            BFS(i, j)
            cnt1 += 1

visited = [[False] * N for _ in range(N)]

cnt2=0

for i in range(N):
    for j in range(N):
        if board[i][j] == 'G':
            board[i][j] = 'R'  
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            BFS(i, j)
            cnt2 += 1

print(cnt1,cnt2)
