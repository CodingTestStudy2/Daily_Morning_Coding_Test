<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
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