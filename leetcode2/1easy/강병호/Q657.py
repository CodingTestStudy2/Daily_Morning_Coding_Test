class Solution:
    def judgeCircle(self, moves: str) -> bool:
        
        uCnt = moves.count('U')
        dCnt = moves.count('D')
        lCnt = moves.count('L')
        rCnt = moves.count('R')

        if lCnt == rCnt and uCnt == dCnt:
            return True
        
        return False