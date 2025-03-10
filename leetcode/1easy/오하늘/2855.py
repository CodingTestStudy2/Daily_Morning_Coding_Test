class Solution:
    from collections import deque
    def minimumRightShifts(self, nums: List[int]) -> int:
        n = len(nums)
        target = sorted(nums)
        if target == list(nums):
                return 0
        nums = deque(nums)
        for i in range(1,n+1):
            nums.rotate(1)
            if target == list(nums):
                return i
        return -1
