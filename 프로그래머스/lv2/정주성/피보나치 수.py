# DP 문제
def solution(n):
    DP = [0 for _ in range(n + 1)]
    DP[0] = 0
    DP[1] = 1

    for i in range(2, n + 1):
        DP[i] = (DP[i - 2] + DP[i - 1]) % 1234567

    return DP[n]
