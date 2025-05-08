class Solution:
    def incremovableSubarrayCount(self, nums: List[int]) -> int:
        def cut_arr(arr: List[int]) -> bool:
            return all(arr[i] < arr[i+1] for i in range(len(arr) - 1))

        n = len(nums)
        count = 0

        for l in range(n):
            for r in range(l, n):
                remain = nums[:l] + nums[r+1:]
                if cut_arr(remain):
                    count += 1

        return count
