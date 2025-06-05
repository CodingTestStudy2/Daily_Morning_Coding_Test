<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def smallestNumber(self, n: int, t: int) -> int:
        while True:
            result = 1

            for i in str(n):
               result *= int(i)

            if result % t == 0:
                return n
            
            else: 
                n += 1