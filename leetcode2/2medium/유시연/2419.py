class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        maxNum = max(nums)  
        maxLen = 0
        currentLen = 0
        
        for i in nums:
            if i == maxNum:
                currentLen += 1
                maxLen = max(maxLen, currentLen)
            else:
                currentLen = 0 
        
        return maxLen