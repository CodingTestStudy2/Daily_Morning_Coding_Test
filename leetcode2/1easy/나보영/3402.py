class Solution:
    def minimumOperations(self, grid: List[List[int]]) -> int:
        n = len(grid)
        m = len(grid[0])
        result = 0
        for i in range(m): #열
            for j in range(1, n): #행
                if grid[j][i] <= grid[j-1][i]:
                    result += (grid[j-1][i] + 1) - grid[j][i]
                    grid[j][i] = grid[j-1][i] + 1

        return result
    
from collections import defaultdict

from collections import defaultdict

class Solution:
    def canDistribute(self, nums: List[int], quantity: List[int]) -> bool:
        dic = defaultdict(int)
        n = len(nums)
        for i in nums:
            dic[i] += 1

        
        key = dic.keys()
        def find(current, f):
            if current == n:
                return True
            
            check = quantity[current]

            for i in 


        


            return

        return find(0, set())