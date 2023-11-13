N, M = map(int, input().split())

startx, starty, way =  map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(N)]
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
my_count = 0
while True:
    if matrix[startx][starty] == 0:
        matrix[startx][starty] = -1
        my_count += 1
    count = 0
    for i in range(4):
        nx, ny = startx+dx[i], starty + dy[i]
        if nx >= 0 and ny >= 0 and nx < N and ny < M and matrix[nx][ny] == 0:
            count += 1
    if count == 0 :
        x,y = startx - dx[way], starty - dy[way]
        
        if x >= 0  and y >= 0 and x < N and y < M and matrix[x][y] != 1:
            startx, starty = x, y
            continue
        else:
            break
        # 0 북 , 1 동,  2 남,  3 서
        # 0 -> 3, 1 -> 0 / 2 -> 1  / 3-> 2
    else:
        while True:
            way = (way - 1)% 4
            ax, ay = startx + dx[way], starty + dy[way]
            if matrix[ax][ay] == 0:
                startx, starty = ax, ay
                break
print(my_count)

