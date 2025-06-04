class Leetcode.이재훈.이재훈.Solution:
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        sort_sat = sorted(satisfaction)
        like_time = 0
        count = 1
        now = 0

        while len(sort_sat) > 0:
            for i in range(len(sort_sat)):
                now += sort_sat[i] * count
                count += 1
            
            like_time = max(now , like_time)
            sort_sat.pop(0)
            count = 1
            now = 0

        return like_time

