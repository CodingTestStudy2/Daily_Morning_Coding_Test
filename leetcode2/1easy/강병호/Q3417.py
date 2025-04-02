class Solution:
    def zigzagTraversal(self, grid: list[list[int]]) -> list[int]:
        x, y = 0, 0
        max_x = len(grid[0])
        max_y = len(grid)

        # print("max_y : ", max_y)
        # print("max_x : ", max_x)

        result = list()

        while True:
            if max_y <= y:
                # print("break time")
                # print("y : ", y)
                # print("x : ", x)
                break
            
            # print("y : ", y)
            # print("x : ", x)
            # print(grid[y][x])
            result.append(grid[y][x])
            move_time = 2
            while move_time != 0:
                next_block = x+1 if y % 2 == 0 else x-1
                if next_block < 0 or next_block > max_x-1 :
                    y += 1
                elif y % 2 == 0: # right increase
                    x += 1
                elif y % 2 != 0 : # left increase
                    x -= 1
                
                move_time-=1
        
        return result


if __name__ == "__main__":
    sol = Solution()
    print(sol.zigzagTraversal([[1,2], [3,4]]))
