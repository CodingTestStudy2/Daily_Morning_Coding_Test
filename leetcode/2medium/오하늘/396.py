from collections import deque
class Leetcode.이재훈.Solution:
    def maxRotateFunction(self, nums: List[int]) -> int:
        ans = float('-inf') # 음수의 경우가 있음
        nums_deque = deque(nums)
        n = len(nums)

        for k in range(n):
            nums_deque.rotate(1) # 한 칸씩 회전
            temp = 0
            for i in range(n):
                temp+=i*nums_deque[i]
            if temp>ans:
                ans=temp

        return ans
