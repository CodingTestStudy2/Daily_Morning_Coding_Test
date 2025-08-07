class Solution:
    def numberOfGoodSubarraySplits(self, nums: List[int]) -> int:
        MOD = 10**9+7
        n = len(nums)
        flag = []
    
        # [1, 0,0,0,0,0, 1, 0, 1]
        # 6가지(1+gap) * 2가지(1+gap) * 1
        gap = 0
        for i in range(n):
            if nums[i] == 1:
                flag.append(i)

        # 1이 없는 경우
        if len(flag) == 0:
            return 0

        # 1이 하나만 있는 경우
        if len(flag) == 1:
            return 1
        
        result = 1
        for i in range(1, len(flag)):
            gap = flag[i] - flag[i-1]
            # print(gap, flag)
            result *= gap

        return result % MOD