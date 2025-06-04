class Leetcode.이재훈.이재훈.Solution:
    def minimumRightShifts(self, nums: List[int]) -> int:
        min_idx = nums.index(min(nums))
        new_nums = nums[min_idx:] + nums[:min_idx]
        if new_nums == sorted(nums):
            return (len(nums) - min_idx) % len(nums)
        else:
            return -1
        