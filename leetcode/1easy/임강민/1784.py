<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def checkOnesSegment(self, s: str) -> bool:
        cnt = 0
        for i in range(len(s) - 1):
            if s[i] != s[i + 1]:
                cnt += 1
        if cnt >= 2:
            return False
        else:
            return True

