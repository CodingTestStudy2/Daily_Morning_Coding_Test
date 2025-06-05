<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def minOperations(self, nums: List[int]) -> int:
        n = len(nums)
        answer = 0

        for i in range(n-2):
            if nums[i] == 0:
                nums[i] = 1
                answer += 1
                if nums[i+1] == 0:
                    nums[i+1] = 1
                    if nums[i+2] == 0:
                        nums[i+2] = 1
                        continue
                    if nums[i+2] == 1:
                        nums[i+2] = 0
                        continue
                if nums[i+1] == 1:
                    nums[i+1] = 0
                    if nums[i+2] == 0:
                        nums[i+2] = 1
                        continue
                    if nums[i+2] == 1:
                        nums[i+2] = 0
                        continue

        for i in range(n):
            if nums[i] == 0:
                answer = -1

        return answer
        