import math
class Solution:
    def isThree(self, n: int) -> bool:
        check = n ** 0.5

        if check != int(check):
            return False

        for i in range(2, int(math.sqrt(check)) + 1):
            if check % i == 0:
                return False

        return check > 1