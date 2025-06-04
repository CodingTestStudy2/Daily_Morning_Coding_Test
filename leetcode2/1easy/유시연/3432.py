class Leetcode.이재훈.이재훈.Solution:
    def countPartitions(self, nums: List[int]) -> int:
        n = len(nums)
        count = 0
        for i in range(n-1):
            if sum(nums[:i+1]) % 2 == 0 and sum(nums[i+1:]) % 2 == 0:
                count += 1
            if sum(nums[:i+1]) % 2 != 0 and sum(nums[i+1:]) % 2 != 0:
                count += 1

        return count