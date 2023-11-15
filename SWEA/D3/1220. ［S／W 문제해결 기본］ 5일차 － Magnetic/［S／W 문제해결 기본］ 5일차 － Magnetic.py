for i in range(1,11):
    N = int(input())
    matrix = [list(map(int, input().split())) for _ in range(N)]
    count = 0
    for y in range(0, 100):
        for x in range(0, 100):
            if matrix[x][y] == 1 and x<99:
                if matrix[x+1][y] == 0 or matrix[x+1][y] == 1:
                   matrix[x][y] = 0
                   matrix[x+1][y] = 1
                elif matrix[x+1][y] == 2:
                    count += 1
    print("#{} {}".format(i, count))    
