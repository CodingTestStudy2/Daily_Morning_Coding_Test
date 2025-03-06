class Solution:
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
