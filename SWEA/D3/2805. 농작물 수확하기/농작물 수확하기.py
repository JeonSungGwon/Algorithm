T = int(input())

for i in range(1,T+1):
    N = int(input())
    matrix = [list(map(int, input())) for _ in range(N)]
    sum = 0
    for x in range(0, N//2):
        for y in range(N//2-x, (N//2 + x) + 1):
            sum += matrix[x][y]
    for x in range(N // 2 + 1, N):
        for y in range(x - N//2, (N - x) + N  // 2):
            sum += matrix[x][y]
    for y in range(N):
        sum += matrix[N//2][y]
    print("#{} {}".format(i, sum))


