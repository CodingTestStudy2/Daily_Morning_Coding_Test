<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def specialArray(nums) -> int:
        tmp = 1
        while tmp <= len(nums):
            temp = 0
            for i in nums:
                if i>=tmp:
                    temp+=1
            if temp == tmp:
                return temp
            tmp+=1
        return -1
    
    specialArray([3,5])
