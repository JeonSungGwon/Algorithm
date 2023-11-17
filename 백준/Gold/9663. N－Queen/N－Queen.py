import sys
sys.setrecursionlimit(10000)

def setQueen(R) :
    global queens, C
    
    # 대각선으로 충돌 확인
    if len(queens) > 1 :
        for i in range(len(queens)-1) :
            # 한 퀸으로부터 (+k, +-k) 만큼 떨어져있다면 충돌, return

            # 새로 투입된 퀸만이 조건을 만족하고 들어온 이전 퀸들과만 비교하여 충돌하는지 판별하여 연산 최적화
            k = queens[-1][0]-queens[i][0] # k > 0

            if queens[i][1] + k == queens[-1][1] or queens[i][1] - k == queens[-1][1] : return

    # 조건 충족 및 배치 완료
    if len(queens) == N :
        global setCase
        setCase += 1
        return
    
    # 퀸은 각 행/열에 하나씩 존재할 것
    for c in range(N) :
        if C[c] : continue

        # 추가
        queens.append((R,c))
        C[c] = True
        setQueen(R+1)
        # 복구
        queens.pop()
        C[c] = False


N = int(input())

setCase = 0 # 출력값
queens = [] # (r0, c0), (r1, c1), ...
R = 0 # 진행된 행
C = [False for _ in range(N)] # 할당된 열

setQueen(R)

print(setCase)