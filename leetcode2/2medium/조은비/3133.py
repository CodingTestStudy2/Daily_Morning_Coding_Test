class Solution:
    def minEnd(self, n: int, x: int) -> int:
        # nums AND 연산 결과가 x
        # -> x, x+1, x+2... 중 AND 연산결과가 x

        # 이때 최소 가능 nums[n-1] <- 이면 젤 끝값 (nums 배열 오름차순...)
        nums = []
        a = x

        while len(nums) < n:
            if a & x == x:
                nums.append(a)
            a += 1
            # print(nums)
        return nums[-1]
#ㅠㅠ