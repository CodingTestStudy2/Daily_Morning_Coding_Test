from collections import Counter
class Solution:
    def reorderedPowerOf2(self, n: int) -> bool:
        check = Counter(str(n))

        for i in range(30):
            new = Counter(str(2 ** i))
            if new == check:
                return True
        
        return False