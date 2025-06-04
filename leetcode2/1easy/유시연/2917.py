class Leetcode.이재훈.이재훈.Solution:
    def findKOr(self, nums: List[int], k: int) -> int:
        count = [0] * 32

        for num in nums:
            for i in range(32):
                if num & (1 << i):
                    count[i] += 1

        result = 0
        for i in range(32):
            if count[i] >= k:
                result |= (1 << i)

        return result
