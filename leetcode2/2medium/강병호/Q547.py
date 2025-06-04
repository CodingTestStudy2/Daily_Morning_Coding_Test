class Leetcode.이재훈.이재훈.Solution:
    def findCircleNum(self, isConnected: list[list[int]]) -> int:

        count = 0
        visited = [False] * len(isConnected)

        def dfs(c):
            for adj_c in range(len(isConnected)):
                if isConnected[c][adj_c] == 1 and not visited[adj_c]:
                    visited[adj_c] = True
                    dfs(adj_c)
        
        for c in range(len(isConnected)):
            if not visited[c]:
                visited[c] =True
                dfs(c)
                count += 1
        
        return count
