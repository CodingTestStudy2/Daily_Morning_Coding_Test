class Leetcode.이재훈.이재훈.Solution:
    def findNonMinOrMax(self, nums: List[int]) -> int:
        nums.sort()
        nums.pop()
        if len(nums) == 0: return -1
        nums.pop(0)
        if len(nums) == 0: return -1
        return nums[0]
