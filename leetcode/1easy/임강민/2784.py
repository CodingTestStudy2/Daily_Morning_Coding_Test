# Check if Array is Good
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def isGood(self, nums: List[int]) -> bool:
        flag = True
        nums.sort()
        for i in range(len(nums)):
            if not flag:
                break
            if i >= len(nums) - 2:
                if nums[i] != len(nums) - 1:
                    flag = False
            else:
                if nums[i] != i + 1:
                    flag = False
        return flag
