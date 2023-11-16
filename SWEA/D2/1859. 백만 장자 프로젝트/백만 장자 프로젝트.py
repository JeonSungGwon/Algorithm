T = int(input())

result = []
for _ in range(T):
    max = 0
    count = 0
    N = int(input())
    li = list(map(int, input().split()))
    for i in range(N-1, -1, -1):
        if max < li[i]:
            max = li[i]
        elif max > li[i]:
            count += (max - li[i])
    result.append(count)

for i in range(len(result)):
    print("#{} {}".format(i+1, result[i]))




