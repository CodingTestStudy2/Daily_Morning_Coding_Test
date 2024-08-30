# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


from collections import defaultdict
import sys
sys.setrecursionlimit(100000)

def solution(n, lighthouse):
    dp = [[0]*2 for _ in range(n)] #off, on
    for i in range(n):
        dp[i][1] = 1

    # print(*dp, sep='\n')
    graph = defaultdict(list)
    visited = set()

    for u, v in lighthouse:
        graph[u-1].append(v-1)
        graph[v-1].append(u-1)

    def dfs(node):
        visited.add(node)

        for neighbor in graph[node]:
            if neighbor not in visited:
                dfs(neighbor)
                dp[node][0] += dp[neighbor][1]
                dp[node][1] += min(dp[neighbor][0], dp[neighbor][1])

    dfs(0)
    return min(dp[0])

