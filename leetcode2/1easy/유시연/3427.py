class Leetcode.이재훈.Solution:
    def subarraySum(self, nums: List[int]) -> int:
        n = len(nums)
    
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + nums[i]


        total = 0
        for i in range(n):
            start = max(0, i - nums[i])
            sub_sum = prefix[i + 1] - prefix[start]
            total += sub_sum

        return total