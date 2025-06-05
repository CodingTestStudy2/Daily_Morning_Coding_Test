<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def numberOfChild(self, n: int, k: int) -> int:
        i = -1
        go_right = True

        while k >= 0:
            if i == 0:
                go_right = True
            if i == n-1:
                go_right = False

            if go_right:
                i += 1
                k -= 1

            else:
                i -= 1
                k -= 1
                
        return i

        