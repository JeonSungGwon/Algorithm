
from collections import deque

T = int(input())
for i in range(1, T+1):
    R, C = map(int, input().split())

    matrix = [list(map(str, input())) for _ in range(R)]
    currentX = 0
    currentY = 0
    my_way = (0, 1)
    count = 0
    memory = 0
    q = deque()
    visited = set()
    q.append((currentX, currentY, my_way, memory))
    visited.add((currentX, currentY, my_way, memory))
    while q:
        currentX, currentY, way, memory = q.popleft()

        if matrix[currentX][currentY] in map(str, range(0, 10)):
            memory = int(matrix[currentX][currentY])
        elif matrix[currentX][currentY] == "<":
            way = (0, -1)
        
        elif matrix[currentX][currentY] == ">":
            way = (0, 1)
        elif matrix[currentX][currentY] == "v":
            way = (1, 0)
        elif matrix[currentX][currentY] == "^":
            way = (-1, 0)
        elif matrix[currentX][currentY] == "_":
            if memory == 0:
                way = (0, 1)
            else:
                way = (0, -1)
        elif matrix[currentX][currentY] == "|":
            if memory == 0:
                way = (1, 0)
            else:
                way = (-1, 0)
        elif matrix[currentX][currentY] == "?":
            way = [(0, -1), (-1, 0), (0, 1), (1, 0)]

        elif matrix[currentX][currentY] == ".":
            pass
        elif matrix[currentX][currentY] == "@":
            count += 1
            print("#{} {}".format(i, "YES"))
            break
        elif matrix[currentX][currentY] == "+":
            if memory != 15:
                memory += 1
            else:
                memory = 0
        elif matrix[currentX][currentY] == "-":
            if memory != 0:
                memory -= 1
            else:
                memory = 15
        if matrix[currentX][currentY] == "?":
            for dx, dy in way:
                nx = currentX + dx
                ny = currentY + dy
                my_way = (dx, dy)
                if 0<= nx < R and 0<= ny < C:
                    nextX, nextY = nx, ny
                else:
                    if nx < 0:
                        nextX, nextY = R-1, ny
                    if nx >= R:
                        nextX, nextY = 0, ny
                    if ny < 0:
                        nextX, nextY = nx, C-1
                    if ny >= C:
                        nextX, nextY = nx, 0
                if (nextX, nextY, my_way, memory) not in visited:    
                    visited.add((nextX, nextY, my_way, memory))
                    q.append((nextX, nextY, my_way, memory))
        else:    
            nx = currentX + way[0]
            ny = currentY + way[1]
            if 0<= nx < R and 0<= ny < C:
                nextX, nextY = nx, ny
            else:
                if nx < 0:
                    nextX, nextY = R-1, ny
                if nx >= R:
                    nextX, nextY = 0, ny
                if ny < 0:
                    nextX, nextY = nx, C-1
                if ny >= C:
                    nextX, nextY = nx, 0
            if (nextX, nextY,way, memory) not in visited:    
                visited.add((nextX, nextY, way, memory))
                q.append((nextX, nextY, way, memory))

    if count == 0:
        print("#{} {}".format(i, "NO"))
        
        
                
             
