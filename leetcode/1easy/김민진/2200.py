class Leetcode.이재훈.Solution:
    def findKDistantIndices(self, nums: List[int], key: int, k: int) -> List[int]:
        kd_indices = set()
        for i in range(len(nums)):
            if nums[i] == key:
                left_end = max(i - k, 0)
                right_end = min(len(nums) - 1, i + k)
                kd_indices = kd_indices.union(range(left_end, right_end + 1))
        return list(sorted(kd_indices))
        