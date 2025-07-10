class Solution:
    def is_distinct(self, nums: List[int]) -> bool:
        check = {}
        for num in nums:
            if num in check:
                return False
            check[num] = 1
        return True
        
    def minimumOperations(self, nums: List[int]) -> int:
        # 3개씩 지우되 3개 이하면 전체 삭제
        # 어레이가 동일한값X 만드는 최소 operation

        n = len(nums)
        for i in range(0, n, 3):
            split = nums[i:]
            if self.is_distinct(split):
                # print('if', i, nums[i:])
                return i // 3
            # print('else',i, nums[i:])
        return i // 3 + 1