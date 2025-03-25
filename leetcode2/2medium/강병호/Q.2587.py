class Solution:
    def maxScore(self, nums: list[int]) -> int:
        sorted_nums = sorted(nums, reverse=True)

        result = 0
        prefix = 0

        for data in sorted_nums:
            result += data
            if result <= 0:
                break
            else:
                prefix += 1
        
        return prefix
    

if __name__ == "__main__":
    solution = Solution()

    print(solution.maxScore([2, -1, 0, 1, -3, 3, -3]))
    print(solution.maxScore([-2, -3, 0]))