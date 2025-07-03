#시간 초과
class Solution:
    def maxSumRangeQuery(self, nums: List[int], requests: List[List[int]]) -> int:
        n = len(nums)
        count = [0] * n

        for a, b in requests:
            b = b + 1
            for i in range(a, b):
                count[i] += 1

        
        nums.sort()
        count.sort()
        result = 0
        
        for i in range(n):
            result += nums[i] * count[i]
            result = result % (10**9 + 7)

        return result