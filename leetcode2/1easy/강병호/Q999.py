

<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    # 위 오 아 왼

    def numRookCaptures(self, board: list[list[str]]) -> int:

        dx = [0, 1, 0, -1]
        dy = [1, 0, -1, 0]
        result = 0
        def findRookLocIdx():
            for i in range(0, 8):
                for j in range(0, 8):
                    if board[i][j] == 'R':
                        return i, j
        
        loc_x, loc_y = findRookLocIdx()
        
        for i in range(0, 4):
            next_x, next_y = loc_x, loc_y
            while True:
                if next_x == -1 or next_x == 8 or next_y == -1 or next_y == 8:
                    break
                
                if board[next_x][next_y] == 'B':
                    break
                elif board[next_x][next_y] == 'p':
                    result+=1
                    break

                next_x += dx[i]
                next_y += dy[i]
        
        print(result)

        return result
    



if __name__ == "__main__":
<<<<<<< HEAD
    sol = Leetcode.이재훈.이재훈.Solution()
=======
    sol = Leetcode.이재훈.Solution()
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424

    sol.numRookCaptures([[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]])

    
