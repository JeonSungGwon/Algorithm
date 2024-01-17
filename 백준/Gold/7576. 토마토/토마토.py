from collections import deque

M, N = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]
q = deque([])

d = [(0, 1), (1, 0), (-1 ,0), (0, -1)]

result = 0

for i in range(N):
    for j in range(M):
        if board[i][j] == 1:
            q.append([i, j])

def BFS():
    while q:
        x, y = q.popleft()
        for dx, dy in d:
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny <M and board[nx][ny] == 0:
                board[nx][ny] = board[x][y] + 1
                q.append([nx, ny])

BFS()
for i in board:
    for j in i:
        if j == 0:
            print(-1)
            exit(0)
    result = max(result, max(i))

print(result - 1)   



