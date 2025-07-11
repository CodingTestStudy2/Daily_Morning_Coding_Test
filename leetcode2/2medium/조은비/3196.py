class Solution:
    def calc_cost(self, arr):
        total = 0
        i = 0
        for num in arr:
            if i % 2 == 0:
                total += num
            else:
                total -= num
            i+=1
        return total
        
    def maximumTotalCost(self, nums: List[int]) -> int:
        n = len(nums)

        # 부분배열 합
        for i in range(n):
            arr = []
            for j in range(i, n):
                arr.append(nums[j])
                cost = self.calc_cost(arr)
                print(arr, cost)

        # +-+-/+-+-
        # +-+/+-+-+
        
        # 이니까 왼쪽이 홀수개(짝수인덱스)로 끝나면 총합 = 왼쪽-(오른쪽)
        # 이니까 왼쪽이 짝수개(홀수인덱스)로 끝나면 총합 = 왼쪽+(오른쪽)

