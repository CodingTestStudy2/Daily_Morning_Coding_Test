class Solution:
    def longestAlternatingSubarray(self, nums: List[int], threshold: int) -> int:
        max_result = 0
        result = 0
        n = len(nums)

        for i in range(n):
            if nums[i] % 2 == 0 and nums[i] <= threshold:
                result = 1
                
                for j in range(i + 1, n):
                    if nums[j] > threshold:
                        break
                
                    if nums[j] % 2 == nums[j - 1] % 2:
                        break
                    
                    result += 1
                
                max_result = max(max_result, result)

        return max_result
