class Solution:
    def maximumJumps(self, nums: List[int], target: int) -> int:
        n = len(nums)
        dp = [-1] * n
        dp[n-1] = 0
        def find(current):
            if current == n-1:
                return 

            check = -2
            for i in range(current + 1, n):
                if abs(nums[current] - nums[i]) <= target:
                    if dp[i] > -1:
                        check = max(check, dp[i]+1)
                    elif dp[i] == -1:
                        find(i)
                        if dp[i] != -2:
                            check = max(check, dp[i]+1)

            dp[current] = check
            return


        find(0)
        if dp[0] < 0:
            return -1


        return dp[0]