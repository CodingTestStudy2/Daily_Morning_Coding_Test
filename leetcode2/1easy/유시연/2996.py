<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def missingInteger(self, nums: List[int]) -> int:
        max_sum = nums[0]
        for i in range(1, len(nums)):
            if nums[i] == nums[i-1] + 1:
                max_sum += nums[i]
            else:
                break
        
        j = max_sum
        while j in nums:
            j +=1
        
        return j