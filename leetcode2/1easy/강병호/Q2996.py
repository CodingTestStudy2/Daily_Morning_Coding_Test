class Leetcode.이재훈.Solution:
    def missingInteger(self, nums: list[int]) -> int:
        
        prefix_sum = nums[0]

        for i in range(1, len(nums)):
            if nums[i] == nums[i-1] + 1:
                prefix_sum += nums[i]
                continue
            else:
                break
        
        while True:
            if not prefix_sum in nums:
                return prefix_sum
            else:
                prefix_sum += 1

        return prefix_sum