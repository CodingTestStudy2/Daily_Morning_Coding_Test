<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def subarraySum(self, nums: list[int]) -> int:
        result = 0
        for i, num in enumerate(nums):
            start = i - num if 0 < i - num else 0

            if start == i:
                result += num
            else:
                for j in range(start, i+1):
                    result += nums[j]

        return result

if "__main__" == __name__:
<<<<<<< HEAD
    sol = Leetcode.이재훈.이재훈.Solution()
=======
    sol = Leetcode.이재훈.Solution()
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    print(sol.subarraySum([2, 3, 1]))
    print(sol.subarraySum([3, 1, 1, 2]))
