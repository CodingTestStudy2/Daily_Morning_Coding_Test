<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def generateKey(self, num1: int, num2: int, num3: int) -> int:
        n1 = f"{num1:04d}"
        n2 = f"{num2:04d}"
        n3 = f"{num3:04d}"
    
        key_digits = []

        for i in range(4):
            min_digit = min(int(n1[i]), int(n2[i]), int(n3[i]))
            key_digits.append(str(min_digit))

        key_str = ''.join(key_digits)


        return int(key_str)