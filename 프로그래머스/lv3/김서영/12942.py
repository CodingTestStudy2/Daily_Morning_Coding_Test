def solution(matrix_sizes):
    n = len(matrix_sizes)
    dp = [[10000 for _ in range(n)] for _ in range(n)]
    for i in range(n): dp[i][i] = 0
    for gap in range(1, n):
        for i in range(n - gap):
            j = i + gap
            for k in range(i, j):
                print(f"gap:{gap} i:{i} j:{j}")
                p = dp[i][k] + dp[k+1][j] + matrix_sizes[i-1][0] * matrix_sizes[k][0] * matrix_sizes[j][1]
                print(dp, p)
                if dp[i][j] > p: dp[i][j] = p
    return dp[0][-1]