
N = int(input())

value = 0
while True:
    reversed_number = int(str(N)[::-1])
    if reversed_number == N:
        for i in range(2, N):
            if N % i == 0:
                break
            if i == N - 1:
                value = N
    if N == 2:
        value = 2
    if value != 0:
        break
    N += 1

print(value)
