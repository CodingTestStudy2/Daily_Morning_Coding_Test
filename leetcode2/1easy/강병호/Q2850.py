class Solution:
    def sumIndicesWithKSetBits(self, nums: list[int], k: int) -> int:
        result = 0
        for i, num in enumerate(nums):
            bin_i = bin(i)
            bin_i = bin_i[2:]
            if bin_i.count("1") == k:
                result += num
        
        return result
if __name__ == "__main__":
    sol = Solution()
    print(sol.sumIndicesWithKSetBits([1, 2, 3, 4, 5], 2))