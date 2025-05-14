class Solution:
    def numIslands(self, grid: list[list[str]]) -> int:
        if not grid:
            return 0
        
        count = 0

        def dfs(row, col):
            if row < 0 or row >= len(grid) or col < 0 or col >= len(grid[0]) or grid[row][col] == '0':
                return
            
            grid[row][col] = '0'

            dfs(row+1, col)
            dfs(row, col+1)
            dfs(row-1, col)
            dfs(row, col-1)
        

        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == '1':
                    dfs(r, c)
                    count += 1
        

        return count
