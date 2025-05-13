class NeighborSum:

    def __init__(self, grid: list[list[int]]):
        self.grid = grid
        self.adj_x = [-1, 0, 1, 0]
        self.adj_y = [0, -1, 0, 1]
        self.dia_x = [-1, 1, 1, -1]
        self.dia_y = [-1, -1, 1, 1]

    def adjacentSum(self, value: int) -> int:
        # top -> left -> bottom -> right
        x, y = self.findValueLoc(value)
        result = 0
        # print("================================")
        # print(f"value : {value}")
        # print(f"x : {x}, y : {y}")


        for direction in range(0, 4):
            next_x, next_y = x + self.adj_x[direction], y + self.adj_y[direction]
            # print(f"next_x : {next_x} , next_y : {next_y}")
            if not self.isExist(next_x, next_y):
                continue
            result += self.grid[next_y][next_x]

        return result

    def diagonalSum(self, value: int) -> int:
        # top-left -> bottom-left -> bottom-right -> top-right
        x, y = self.findValueLoc(value)
        # print("================================")
        # print(f"value : {value}")
        # print(f"x : {x}, y : {y}")
        result = 0

        for direction in range(0, 4):
            next_x, next_y = x + self.dia_x[direction], y + self.dia_y[direction]
            # print(f"next_x : {next_x} , next_y : {next_y}")
            if not self.isExist(next_x, next_y):
                continue
            result += self.grid[next_y][next_x]

        return result



    def findValueLoc(self, value) -> tuple:
        for y in range(0, len(self.grid)):
            for x in range(0, len(self.grid[0])):
                if self.grid[y][x] == value:
                    return (x, y)

    def isExist(self, x:int, y:int) -> bool:
        if y < 0 or x < 0 or y >= len(self.grid) or x >= len(self.grid[0]):
            return False
        return True
        


# Your NeighborSum object will be instantiated and called as such:
# obj = NeighborSum(grid)
# param_1 = obj.adjacentSum(value)
# param_2 = obj.diagonalSum(value)