<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def passThePillow(self, n: int, time: int) -> int:
        if time // (n-1) % 2 == 1:  # right dir
            return n - time % (n - 1)  # (n - 1) - t % (n - 1) + 1
        else:
            return time % (n - 1) + 1