class Solution:
    def satisfiesConditions(self, grid: List[List[int]]) -> bool:
        row = len(grid)
        col = len(grid[0])

        for i in range(row):
            for j in range(col):
                # print(row, col, i, j, grid[i][j])

                # 위아래 같게
                if i + 1 < row and grid[i][j] != grid[i+1][j]:
                    return False

                # 좌우로 다르게
                # 인덱스 넘으면 X: i = col 값일때 i+1 안됨.
                if j + 1 < col and grid[i][j] == grid[i][j+1]:
                    return False

        return True