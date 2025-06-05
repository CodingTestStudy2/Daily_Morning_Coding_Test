<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def furthestDistanceFromOrigin(self, moves: str) -> int:
        arr = list(moves)
        cntl = 0
        cntr = 0
        cnt = 0
        for i in range (len(arr)):
            if arr[i] == 'L': cntl+=1
            if arr[i] == 'R' : cntr+=1
            if arr[i] == '_' : cnt+=1
        
        if cntl>cntr: return cntl+cnt-cntr
        else : return cntr+cnt-cntl
