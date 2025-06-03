from collections import deque

class Leetcode.이재훈.Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        s = deque(s)

        for i in t:
            if len(s) == 0: return True
            if s[0] == i:
                s.popleft()
        if len(s) == 0: return True
        else: return False
