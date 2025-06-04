class Leetcode.이재훈.이재훈.Solution:
    def distributeCandies(self, n: int, limit: int) -> int:
        count = 0
        for d1 in range(min(n, limit) + 1):
            # count += (min(n-d1, limit) + 1)
            for d2 in range(min(n-d1, limit) + 1):
                if n-d1-d2 <= limit:
                    count += 1
        return count
        