class Solution:
    def maxOperations(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 2:
            return 1
        score = 0
        score += nums.pop(0)
        score += nums.pop(0)

        n -= 2
        result = 1

        while(n > 1):
            check = nums.pop(0)
            check += nums.pop(0)
            n -= 2
            if check == score:
                result += 1
            else:
                break

        return result