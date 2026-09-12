class Solution:
    def diagonalSort(self, mat: List[List[int]]) -> List[List[int]]:
        diagonal = defaultdict(list)

        # 1. 같은 대각선끼리 모으기
        for x in range(len(mat)):
            for y in range(len(mat[0])):
                diagonal[x - y].append(mat[x][y])

        # 2. 각 대각선 정렬
        for key in diagonal:
            diagonal[key].sort(reverse=True)

        # 3. 다시 mat에 넣기
        for x in range(len(mat)):
            for y in range(len(mat[0])):
                mat[x][y] = diagonal[x - y].pop()

        return mat
