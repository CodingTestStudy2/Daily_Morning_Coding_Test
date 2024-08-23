def solution(matrix_sizes):
    arr = matrix_sizes
    n = len(arr)

    dp = [[0] * n for _ in range(n)]

    for length in range(1, n):
        for i in range(n-length):
            j = i+length
            dp[i][j] = float('inf') #i번째부터 j번째까지
            for k in range(i,j):
                cost = dp[i][k] + dp[k+1][j] + arr[i][0] * arr[k][1] * arr[j][1]
                dp[i][j] = min(dp[i][j], cost)
    return dp[0][n-1]