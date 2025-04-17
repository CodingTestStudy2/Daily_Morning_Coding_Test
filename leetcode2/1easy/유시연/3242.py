class NeighborSum:

    def __init__(self, grid: List[List[int]]):
        self.grid = grid
        self.n = len(grid)

        self.loc = {val: (i, j) for i, row in enumerate(grid) for j, val in enumerate(row)}

    def adjacentSum(self, value: int) -> int:
        i, j = self.loc[value]
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        return sum(self.grid[ni][nj]
                   for di, dj in dirs
                 

    def diagonalSum(self, value: int) -> int:
        i, j = self.loc[value]
        dirs = [(-1, -1), (-1, 1), (1, -1), (1, 1)] 
        return sum(self.grid[ni][nj]
                   for di, dj in dirs
                   

