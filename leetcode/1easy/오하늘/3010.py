<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution(object):
=======
class Leetcode.이재훈.Solution(object):
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def minimumCost(self, nums):
        result = nums.pop(0)
        nums.sort(reverse = True)
        result += nums[-1]+nums[-2]

        return result
