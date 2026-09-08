'''
첫번째 행: 마지막 열
두번째 행: 중간 열
세번째 행: 첫번째 열
'''
class Solution:
    def rotate(self, mat):
        n = len(mat)
        tmp = [[0] * n for _ in range(n)]
        last = n-1
        for i in range(n):
            for j in range(n):
                tmp[j][last] = mat[i][j]
            last -= 1
        
        return tmp

    def findRotation(self, mat: List[List[int]], target: List[List[int]]) -> bool:
        # print(self.rotate(mat))

        for _ in range(4):
            mat = self.rotate(mat)
            if target == mat:
                return True

        return False    