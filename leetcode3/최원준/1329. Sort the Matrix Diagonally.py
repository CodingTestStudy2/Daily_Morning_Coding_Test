class Solution:
    def diagonalSort(self, mat: List[List[int]]) -> List[List[int]]:
        def helper(a, b):
            nums = []
            row = a
            col = b
            while row < n and col < m:
                nums.append(mat[row][col])
                row += 1
                col += 1
            nums.sort()

            row = a
            col = b
            idx = 0
            while row < n and col < m:
                mat[row][col] = nums[idx]
                row += 1
                col += 1
                idx += 1

        n = len(mat)
        m = len(mat[0])

        for top in range(m):
            helper(0, top)           
        
        for left in range(1, n):
            helper(left, 0)

        return mat
            
