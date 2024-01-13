d = [(0, 1), (0, -1), (-1, 0), (1, 0), (-1, -1), (1, 1), (1, -1), (-1, 1)]

def DFS(x, y, board, w, h, visited):
    for dx, dy in d:
        nx = x + dx
        ny = y + dy

        if (0 <= nx < h) and (0 <= ny < w) and not visited[nx][ny] and board[nx][ny] == 1:
            visited[nx][ny] = True
            DFS(nx, ny, board, w, h, visited)
val_list = []
while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    count = 0
    visited = [[False] * w for _ in range(h)]
    board = [list(map(int, input().split())) for _ in range(h)]
    for i in range(h):
        for j in range(w):
            if board[i][j] == 1 and not visited[i][j]:
                count += 1
                visited[i][j] = True
                DFS(i, j, board, w, h, visited)
    val_list.append(count)

for i in val_list:
    print(i)