class Leetcode.이재훈.Solution:
    def findValidPair(self, s: str) -> str:
        count = {}
        for num in s:
            if num in count:
                count[num] += 1
            else:
                count[num] = 1

        for i in range(len(s) -1):
            num1, num2 = s[i], s[i + 1]

            if num1 != num2 and count[num1] == int(num1) and count[num2] == int(num2):
                return num1 + num2

        return ""
