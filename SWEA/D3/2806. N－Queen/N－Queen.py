def check(x):
    for i in range(x):
        if row[x] == row[i] or abs(row[x] - row[i]) == x - i:
            return False
    return True


def DFS(x):
    global result
    if x == N:
        result += 1
    else:
        for i in range(N):
            row[x] = i
            if check(x):
                DFS(x + 1)

T = int(input())

for i in range(1, T+1):
    N = int(input())
    row = [0] * N
    result = 0
    DFS(0)
    print("#{} {}".format(i, result))