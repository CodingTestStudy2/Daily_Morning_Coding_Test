class Leetcode.이재훈.Solution:
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
    sol = Leetcode.이재훈.Solution()
    print(sol.numberOfChild(3, 5))
    print(sol.numberOfChild(5, 6))
    print(sol.numberOfChild(4, 2))