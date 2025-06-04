class Leetcode.이재훈.이재훈.Solution:
    def minimumSteps(self, s: str) -> int:
        count_swap = 0
        first_1 = None
        for i in range(len(s)):
            if s[i] == "1":
                first_1 = i
                break
        else:
            return 0
            
        for i in range(first_1 + 1, len(s)):
            if s[i] == "0":
                count_swap += (i - first_1)
                first_1 += 1
        return count_swap