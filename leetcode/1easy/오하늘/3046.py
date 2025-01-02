class Solution(object):
    def minimumCost(self, nums):
        result = nums.pop(0)
        nums.sort(reverse = True)
        result += nums[-1]+nums[-2]

        return result
