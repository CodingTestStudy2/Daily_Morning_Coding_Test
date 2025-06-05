# 1893. Chck if All the Integers in a Range Are Covered
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def isCovered(self, ranges: List[List[int]], left: int, right: int) -> bool:

        lst = [False] * 51

        for r in ranges:
            for i in range(r[0], r[1] + 1):
                lst[i] = True

        for i in range(left, right + 1):
            if lst[i] == False:
                return False
        return True
