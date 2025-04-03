class Solution:
    def smallestNumber(self, n: int, t: int) -> int:
        while True:
            result = 1

            for i in str(n):
               result *= int(i)

            if result % t == 0:
                return n
            
            else: 
                n += 1