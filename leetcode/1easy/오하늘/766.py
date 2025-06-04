class Leetcode.이재훈.이재훈.Solution:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        # 가로, 세로 다 돌려보면 될듯?
        m, n = len(matrix), len(matrix[0])

        # 가로 방향
        for col in range(n):
            value = matrix[0][col]
            i, j = 0, col
            while i < m and j < n:
                if matrix[i][j] != value:
                    return False
                i += 1
                j += 1

        # 세로 방향
        for row in range(1, m):  # row=1부터 시작
            value = matrix[row][0]
            i, j = row, 0
            while i < m and j < n:
                if matrix[i][j] != value:
                    return False
                i += 1
                j += 1

        return True
