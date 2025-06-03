class Leetcode.이재훈.Solution:
    def canMakeSquare(self, grid: List[List[str]]) -> bool:
        for i in range(2):
            for j in range(2):
                n_black = grid[i][j:j+2].count("B") + grid[i+1][j:j+2].count("B")
                if n_black != 2:
                    return True
        else:
            return False
        