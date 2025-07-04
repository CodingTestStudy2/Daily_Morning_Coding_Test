class Solution(object):
    def satisfiesConditions(self, grid):
        
        rows = len(grid)
        cols = len(grid[0])
        
        for i in range(0, rows):
            for j in range(0, cols):
                bottom = True
                right = True
                if i + 1 < rows:
                    right = (grid[i][j] == grid[i+1][j])
                if j + 1 < cols:
                    bottom =  (grid[i][j] != grid[i][j+1])
                if ((bottom and right) == False):
                    return False

        return True
