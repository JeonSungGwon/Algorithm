N = int(input())
A = list(map(int, input().split()))
S = [0]*N

#삽입 정렬

for i in range(1,N):
    insert_point = i
    insert_value = A[i]
    for j in range(i, -1, -1):
        if A[j]<A[i]:
            insert_point = j+1
            break
        if j==0:
            insert_point = 0 
    
    for j in range(i,insert_point, -1):
        A[j] = A[j-1]
    A[insert_point] = insert_value

sum = 0
for i in range(0, N):
    if S==0:
        S[0] = A[0]
    else:
        S[i] = A[i]+S[i-1]
    sum += S[i]
print(sum)
