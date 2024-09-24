# https://school.programmers.co.kr/learn/courses/30/lessons/42898
def solution(m, n, puddles):
    answer = 0
    # puddles 좌표 거꾸로
    puddles = [[b,q] for [q,b] in puddles]
    grid = [[0] * (m+1) for _ in range(n+1)]
    grid[1][1] = 1
    
    # 행렬은 행먼저 돌고 열 도는것 잊지 말기
    for i in range(1,n+1):
        for j in range(1,m+1):
            if i == 1 and j == 1:
                continue
            # 웅덩이면 값 0
            if [i,j] in puddles:
                grid[i][j] = 0
            # 아니면 위, 왼쪽 합산 값 추가
            else:
                grid[i][j] = (grid[i-1][j] + grid[i][j-1]) % 1000000007
    return grid[n][m]