from collections import deque

<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def isSubsequence(self, s: str, t: str) -> bool:
        s = deque(s)

        for i in t:
            if len(s) == 0: return True
            if s[0] == i:
                s.popleft()
        if len(s) == 0: return True
        else: return False
