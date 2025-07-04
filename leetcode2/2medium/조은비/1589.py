class Solution:
    # [_,_,_,_,_] 에서
    #  0 1 2 3 4
    # 겹치는 구간 nums[1]에서 가장 큰 수
    # nums[0] == nums[2] + nums[3]

    def maxSumRangeQuery(self, nums: List[int], requests: List[List[int]]) -> int:
        
        MOD = 10**9+7
        result = None
        n = len(nums)
        index = [0] * n

        # 여기서 타임 오류 나는듯??
        for s,e in requests:
            for i in range(s, e+1):
            # 해당 구간을 전부 +1 해야하는디
                index[i] += 1

        # 겹치는 구간중 젤 많이 겹치는 부분에 큰 수 올려야 함
        index.sort()
        nums.sort()
        
        # 0인부분은 0으로 하고 나머지 더하고 싶음 index*nums 하고 음..
        result = 0
        # nums를 순환하면서 
        # num * index[i] 를 해서 더하기
        for i in range(n):
            result += nums[i] * index[i]
        # print(index, nums, result)

        return result % MOD