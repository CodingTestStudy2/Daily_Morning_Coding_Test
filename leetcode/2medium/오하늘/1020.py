from collections import deque

dx = [-1, 1, 0, 0]  # 상, 하, 좌, 우
dy = [0, 0, -1, 1]

<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution(object):
=======
class Leetcode.이재훈.Solution(object):
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def numEnclaves(self, grid):
        def bfs(x, y):
            queue = deque([(x, y)])
            grid[x][y] = 0  # 방문 표시
            while queue:
                cx, cy = queue.popleft()
                for i in range(4):
                    nx = cx + dx[i]
                    ny = cy + dy[i]
                    if 0 <= nx < len(grid) and 0 <= ny < len(grid[0]) and grid[nx][ny] == 1:
                        grid[nx][ny] = 0  # 0 처리
                        queue.append((nx, ny))

        for i in range(len(grid)):
            for j in range(len(grid[0])): # 육지에 닿는 곳들다 0 처리
                if (i == 0 or i == len(grid) - 1 or j == 0 or j == len(grid[0]) - 1) and grid[i][j] == 1:
                    bfs(i, j)

        result = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    result += 1

        return result
