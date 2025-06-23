class Solution:
    def canBeIncreasing(self, nums: list[int]) -> bool:
        
        remove_cnt = 1
        i = 1
        n = len(nums)

        while True:
            print(f"i : {i}")
            if i == 0:
                i+=1
            if i == len(nums) - 1:
                break
            if nums[i-1] >= nums[i] and not remove_cnt:
                return False
            elif nums[i-1] >= nums[i] and remove_cnt:
                nums.pop(i-1)
                i = i - 1
                remove_cnt -= 1
                continue

            i += 1

        return True
