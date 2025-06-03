class Leetcode.이재훈.Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        if not nums:
            return 0       
        n = len(nums)

        # DP 구현
        dp_up = [1]*n
        dp_down = [1]*n

        for i in range(1, n):
            if nums[i] > nums[i-1]: # 증가
                dp_up[i] = dp_down[i-1]+1
                dp_down[i] = dp_down[i-1]
            elif nums[i] < nums[i-1]: # 감소
                dp_down[i] = dp_up[i-1] + 1
                dp_up[i] = dp_up[i-1]
            else: # 값이 같은 경우
                dp_up[i] = dp_up[i-1]
                dp_down[i] = dp_down[i-1]

        return max(dp_up[-1], dp_down[-1])
