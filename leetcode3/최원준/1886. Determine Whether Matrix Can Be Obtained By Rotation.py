#

'''
1. 아이디어 :
-

2. 시간복잡도 :
    O(n * m)

3. 자료구조/알고리즘 :
-

'''
class Solution:
    def findRotation(self, mat: List[List[int]], target: List[List[int]]) -> bool:
        n = len(mat)
        m = len(mat[0])
        # 0, 90, 180, 270
        ans = [1, 1, 1, 1]
        for row in range(n):
            for col in range(m):
                if mat[row][col] != target[row][col]:
                    ans[0] = 0
                if mat[row][col] != target[col][n-row-1]:
                    ans[1] = 0
                if mat[row][col] != target[n-row-1][m-col-1]:
                    ans[2] = 0
                if mat[row][col] != target[n-col-1][row]:
                    ans[3] = 0
    
        return sum(ans) >= 1
                
