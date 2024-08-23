def solution(matrix_sizes):
    answer = 0
    n = len(matrix_sizes)
    dp = [[1e10 for _ in range(n)] for _ in range(n)]
    for i in range(n): dp[i][i] = 0
    for gap in range(1, n):
        for i in range(n - gap):
            j = i + gap
            for k in range(i, j):
                p = dp[i][k] + dp[k+1][j] + matrix_sizes[i][0] * matrix_sizes[k][1] * matrix_sizes[j][1]
                dp[i][j] = min(dp[i][j], p)
    return dp[0][-1]