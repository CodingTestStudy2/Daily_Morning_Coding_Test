class Solution:
    def maxSum(self, nums: List[int], k: int, m: int) -> int:
        n = len(nums)
        sum_arr = [0] * (n+1)
        # 정수배열 nums, 뽑을 서브배열 개수 k, 서브배열의 최소 길이 m

        # 일단 시작점 별 합 구하기
        for i in range(n):
            sum_arr[i+1] = sum_arr[i] + nums[i]
        
        # m 구간의 합
        # 합 배열 [시작점 [서브합, 서브합, 서브합... k개]][합]]
        win_sum = [[0] * (k+1) for _ in range(n+1)]

        for i in range(1, n+1): 
            for j in range(1, k+1):
                win_sum[i][k] = max(win_sum[i][j], win_sum[i-1][j])
                print(win_sum[i])

                # 이제 윈도우 길이에 대한 합 구해야함...

        print(win_sum)