class Solution:
    def numRookCaptures(self, board: List[List[str]]) -> int:
        
        count = 0
        rook = (0, 0)
        for i in range(8):
            for j in range(8):
                if board[i][j] == 'R':
                    rook = (i,j)
                    break
                    
        R_Y = rook[1]
        R_X = rook[0]
        while R_X >= 0:
            if board[R_X][R_Y] == 'B':
                break
            if board[R_X][R_Y] == 'p':
                count += 1
                break
            R_X -= 1

        R_X = rook[0]
        while R_X < 8:
            if board[R_X][R_Y] == 'B':
                break
            if board[R_X][R_Y] == 'p':
                count += 1
                break
            R_X += 1
        
        R_X = rook[0]
        R_Y = rook[1]
        while R_Y >= 0:
            if board[R_X][R_Y] == 'B':
                break
            if board[R_X][R_Y] == 'p':
                count += 1
                break
            R_Y -= 1

        R_Y = rook[1]
        while R_Y < 8:
            if board[R_X][R_Y] == 'B':
                break
            if board[R_X][R_Y] == 'p':
                count += 1
                break
            R_Y += 1
        
        return count
                    
                
            
        