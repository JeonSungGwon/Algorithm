from collections import deque

T = int(input())
dx = [0, 1, -1, 0]
dy = [1, 0, 0, -1]
for i in range(1,T+1):
    q = deque()
    N = int(input())
    matrix = [list(map(int, input())) for _ in range(N)]
    dp = [[99999] * N for _ in range(N)]
    dp[0][0] = 0
    q.append((0,0))
    while q:
        x, y = q.popleft()
        
        for j in range(4):
            nx, ny = x+dx[j], y+dy[j]

            if 0<=nx<N and 0<=ny<N:
                if dp[x][y] + matrix[nx][ny] < dp[nx][ny]:
                    dp[nx][ny] = dp[x][y] + matrix[nx][ny]
                    q.append((nx,ny))
    print("#{} {}".format(i, dp[-1][-1]))

