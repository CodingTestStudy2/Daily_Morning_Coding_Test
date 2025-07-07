class Solution:
    def circularArrayLoop(self, nums: List[int]) -> bool:
        n = len(nums)
        check = [0] * n
        for i in range(n):
            bic = 0
            if nums[i] > 0:
                bic = 1
            
            current = (i + nums[i]) % n
            post = i
            newi = i - n
            while(1):
                if current == post or current == post - n:
                    break
                
                if current == i or current == newi:
                    return True
                
                if nums[i] * nums[current] > 0:
                    if current < 0:
                        current += n
                    post = current
                    current = (current + nums[current]) % n
                else:
                    break




        return False