class Leetcode.이재훈.이재훈.Solution:
    def countCompleteDayPairs(self, hours: List[int]) -> int:
        n = len(hours)
        count = 0

        for i in range(n):
            for j in range(n):
                if i <= j:
                    continue
                if (hours[i]+hours[j]) % 24 == 0:
                    count += 1


        return count