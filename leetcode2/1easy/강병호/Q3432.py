class Leetcode.이재훈.Solution:
    def countPartitions(self, nums: list[int]) -> int:
        result = 0
        
        for i in range(0, len(nums)-1):
            leftSum = sum(nums[0:i+1])
            rightSum = sum(nums[i+1:])

            print(f"leftSum : {leftSum}")
            print(f"rightSum : {rightSum}")
            if abs(leftSum - rightSum) % 2 == 0:
                result += 1

        return result