class Leetcode.이재훈.Solution:
    def generateKey(self, num1: int, num2: int, num3: int) -> int:
        num1 = str(num1)
        num2 = str(num2)
        num3 = str(num3)

        num1 = num1.rjust(4, '0')
        num2 = num2.rjust(4, '0')
        num3 = num3.rjust(4, '0')

        result = ""

        for i in range(0, 4):
            minimum = min(int(num1[i]), int(num2[i]), int(num3[i]))

            result += str(minimum)
        

        return int(result)

if __name__ == "__main__":
    sol = Leetcode.이재훈.Solution()
    print(sol.generateKey(1, 10, 1000))
    print(sol.generateKey(1, 2, 3))
    print(sol.generateKey(1987, 879, 798))