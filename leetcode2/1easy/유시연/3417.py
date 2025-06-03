class Leetcode.이재훈.Solution:
    def zigzagTraversal(self, grid: List[List[int]]) -> List[int]:
        result = []
        flag = False
        
        for i in range(len(grid)):
            if i % 2 == 0:
                for j in range(len(grid[i])):
                    if flag == False:
                        result.append(grid[i][j])
                        flag = True
                    else:
                        flag = False
            else:
                for j in range(len(grid[i])-1,-1,-1):
                    if flag == False:
                        result.append(grid[i][j])
                        flag = True
                    else:
                        flag = False
        
        return result
                    