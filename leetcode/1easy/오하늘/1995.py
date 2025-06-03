from itertools import combinations
class Leetcode.이재훈.Solution:
    def countQuadruplets(nums) -> int:
        # 중복 가능
        ans = 0
        for a, b, c, d in combinations(nums, 4):
            if a+b+c == d:
                ans+=1
        return ans
