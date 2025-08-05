class NumArray:
    def __init__(self, nums: List[int]):
        self.nums = nums
        self.left = None
        self.right = None
        # arr index별 누적합
        self.n = len(self.nums)
        self.sum_arr = [0] * (self.n+1)

        for i in range(self.n):
            self.sum_arr[i+1] = self.sum_arr[i] + nums[i]

    def update(self, index: int, val: int) -> None:
        diff = val - self.nums[index]
        self.nums[index] = val

        for i in range(index, self.n):
            self.sum_arr[i+1] = self.sum_arr[i] + self.nums[i]

    def sumRange(self, left: int, right: int) -> int:
        return self.sum_arr[right]-self.sum_arr[left]

# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(index,val)
# param_2 = obj.sumRange(left,right)