class Solution:
    def minSubArrayLen(self, target: int, nums: list[int]) -> int:
        nums.sort(reverse=True)

        print(f"nums : {nums}")

        if sum(nums) < target:
            return 0
        
        sum_res = 0
        cnt = 0
        for num in nums:
            sum_res += num
            cnt += 1

            if sum_res >= target:
                print(f"sumres : {sum_res} // cnt : {cnt}")
                return cnt


            