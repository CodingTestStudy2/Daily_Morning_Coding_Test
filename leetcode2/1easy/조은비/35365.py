class Solution:
    def maxProduct(self, n: int) -> int:
        # max product 

        str_n = str(n)
        nums = []
        for i in str_n:
            nums.append(int(i))

        result = 0
        for i in range(len(nums)):
            for k in range(i+1, len(nums)):
                result = max(result, nums[i] * nums[k])
                # print(i, k, nums[i], nums[k], result)
        return result