<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def distributeCandies(self, n: int, limit: int) -> int:
        count = 0
        for d1 in range(min(n, limit) + 1):
            # count += (min(n-d1, limit) + 1)
            for d2 in range(min(n-d1, limit) + 1):
                if n-d1-d2 <= limit:
                    count += 1
        return count
        