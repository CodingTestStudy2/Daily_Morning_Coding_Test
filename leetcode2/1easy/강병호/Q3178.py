<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def numberOfChild(self, n: int, k: int) -> int:

        time = 0
        loc = 0
        direction_right = True

        while time != k:
            if direction_right:
                loc+=1
            else:
                loc-=1

            time+=1

            if loc == n-1:
                direction_right = False
            elif loc == 0: 
                direction_right = True

        return loc


if __name__ == "__main__":
<<<<<<< HEAD
    sol = Leetcode.이재훈.이재훈.Solution()
=======
    sol = Leetcode.이재훈.Solution()
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    print(sol.numberOfChild(3, 5))
    print(sol.numberOfChild(5, 6))
    print(sol.numberOfChild(4, 2))