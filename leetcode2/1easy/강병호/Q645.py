class Leetcode.이재훈.이재훈.Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        duplicate, miss  = -1, -1

        for num in nums:
            idx = abs(num) - 1
            if nums[idx] < 0:
                duplicate = abs(num)
            else:
                nums[idx] *= -1

        for i, num in enumerate(nums):
            if num > 0:
                miss = i + 1
                break

        return [duplicate, miss]