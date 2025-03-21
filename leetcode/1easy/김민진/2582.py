class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        if time // (n-1) % 2 == 1:  # right dir
            return n - time % (n - 1)  # (n - 1) - t % (n - 1) + 1
        else:
            return time % (n - 1) + 1