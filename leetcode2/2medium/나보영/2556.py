from collections import deque
class Solution:
    def isPossibleToCutPath(self, grid: List[List[int]]) -> bool:
        m = len(grid)
        n = len(grid[0])



        def find(a, b):
            if a == m -1 and b == n -1:
                return True
            
            

            if a >= m or b >= n or grid[a][b] == 0:
                return False
            
            grid[a][b] = 0

            return find(a+1, b) or find(a, b+1)


        if not find(0, 0):
            return True
        
        grid[0][0] = 1

        if not find(0, 0):
            return True
        
        return False