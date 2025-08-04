class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        seq = [1]*n

        # bef < af
        for i in range(n):
            for j in range(i):
                # print(j, nums[j], '-', i, nums[i], seq)
                if nums[j] < nums[i]:
                    seq[i] = max(seq[i], seq[j]+1)
                
        return max(seq)

        # [10,09,02,05,03,07,101,18]
        # [00, 00, 01, 01, 03, 04, 
