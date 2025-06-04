class Leetcode.이재훈.이재훈.Solution:
    def sortMatrix(self, grid: list[list[int]]) -> list[list[int]]:
        def recur(x:int, y:int) -> None:
            
            if x < 0 or x >= len(grid[0]) or y < 0 or y >= len(grid):
                return

            temp = list()
            m_x = x
            m_y = y
            while m_x < len(grid[0]) and m_y < len(grid):
                # print(f"append data : {grid[m_y][m_x]}")
                temp.append(grid[m_y][m_x])
                m_x += 1
                m_y += 1
            
            # if x not 0 -> not reverse
            if not x:
                temp.sort(reverse=True)
            else:
                temp.sort()

            # print(f"sorted list : {temp}")

            for data in temp:
                # print(f"data : {data}")
                grid[y][x] = data
                y+=1
                x+=1
        

        recur(0, 0)
        
        for i in range(1, len(grid[0])):
            recur(i, 0)
        
        for j in range(1, len(grid)):
            recur(0, j)

        return grid

if __name__ == "__main__":
    sol = Leetcode.이재훈.이재훈.Solution()

    print(sol.sortMatrix([[1,7,3],[9,8,2],[4,5,6]]))
    print(sol.sortMatrix([[0,1],[1,2]]))
    print(sol.sortMatrix([[1]]))