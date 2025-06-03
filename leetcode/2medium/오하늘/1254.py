from collections import deque
class Leetcode.이재훈.Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        # 벽을 만나면 섬이 아님
        # 0을 기준으로 bfs를 돌리되 벽을 만나면 return

        dx = [-1,1,0,0] # 상하좌우
        dy = [0,0,-1,1]

        def bfs(x, y, visited):
            q = deque([(x, y)])
            visited[x][y] = True
            isClosed = True  # 섬이 닫혀있는지 여부 체크

            while q:
                x, y = q.popleft()  # pop() -> popleft() (BFS에서 pop은 stack 동작)
                for i in range(4):
                    nx, ny = x + dx[i], y + dy[i]

                    if not (0 <= nx < len(grid)) or not (0 <= ny < len(grid[0])):
                        isClosed = False  # 경계를 만나면 열린 섬
                        continue  # 경계를 넘어가면 무시

                    if visited[nx][ny] or grid[nx][ny] == 1:
                        continue

                    visited[nx][ny] = True
                    q.append((nx, ny))
            
            return 1 if isClosed else 0  # 닫힌 섬이면 1, 아니면 0

        visited = [[False] * len(grid[0]) for _ in range(len(grid))]
        ans = 0
        for i in range (len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 0 and not visited[i][j]:
                    ans += bfs(i,j,visited)
        return ans
