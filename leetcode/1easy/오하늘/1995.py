from itertools import combinations
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def countQuadruplets(nums) -> int:
        # 중복 가능
        ans = 0
        for a, b, c, d in combinations(nums, 4):
            if a+b+c == d:
                ans+=1
        return ans
