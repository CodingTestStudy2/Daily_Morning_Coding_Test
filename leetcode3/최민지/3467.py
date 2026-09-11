class Solution:
    def transformArray(self, nums: List[int]) -> List[int]:
        odd, even = 0, 0
        for n in nums:
            if n % 2 == 0:
                even += 1
            else:
                odd += 1
        result = [0] * even + [1] * odd
    
        return result