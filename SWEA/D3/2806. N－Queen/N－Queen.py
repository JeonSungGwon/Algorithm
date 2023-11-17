T = int(input())
def DFS(x, x_list, y_list):
    global count
    if len(x_list) == N:
        count += 1
    else:
        for k in range(N):
            di = True
            for ax, ay in zip(x_list, y_list):
                for m in range(1, N):
                    if (ax == x - m and ay == k - m) or (ax == x - m and ay == k + m):
                        di = False
            if not di:
                continue
            elif k in y_list:
                continue
            else:
                x_list.append(x)
                y_list.append(k)
                DFS(x + 1, x_list, y_list)
                x_list.pop()
                y_list.pop()

for i in range(1, T + 1):
    count = 0
    N = int(input())
    total_count = 0
    for j in range(N):
        DFS(1, [0], [j])
    print("#{} {}".format(i, count))
