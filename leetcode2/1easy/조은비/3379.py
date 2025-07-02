# 원형 배열
class Solution(object):
    def constructTransformedArray(self, nums):
        
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
        result = [None] * n

        for i in range(n):
        # 0이면 0
            if nums[i] == 0:
                result[i] = 0
            elif nums[i] < 0:
                idx = (i - abs(nums[i])) % n
                result[i] = nums[idx]
            else: 
                idx = (i + nums[i]) % n
                result[i] = nums[idx]
        return result

        
        # 음수면 왼쪽으로 abs(num[i]) 이동
        # 양수면 오른쪽으로 num[i] 이동