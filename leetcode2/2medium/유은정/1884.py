class Solution(object):
    def twoEggDrop(self, n):
        x = 1
        while x * (x + 1) // 2 < n:
            x += 1
        return x 
