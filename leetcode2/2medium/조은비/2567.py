class Solution:
    def minimizeSum(self, nums: List[int]) -> int:
        # 차의 절댓값 최대/최소의 합이 score
        # 최소 score를 반환

        # low 한쪽은 무조건 0?
        # 최대값 줄이기
        nums.sort()
        n = len(nums)

        # 바꾸는 숫자는 low에 맞춰지니까 low 만드는 case...
        # ex1에서 같은 숫자가 없어서 저체된듯??

        return min(
            nums[n-3] - nums[0],
            nums[n-1] - nums[2],
            nums[n-2] - nums[1]
        )