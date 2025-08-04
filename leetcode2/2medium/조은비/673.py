class Solution:
    def findNumberOfLIS(self, nums: List[int]) -> int:
        # 300번 문제 솔루션떼옴
        # 이번엔 substring 개수도 세어야함
        n = len(nums)
        seq = [1] * n
        cnt = [1] * n

        # bef < af
        for i in range(n):
            for j in range(i):
                if nums[j] < nums[i]: # 후행이 선행보다 클때
                    # substring 누적으로 길이연장
                    # 이때 substring 개수 세기
                    if seq[i] < seq[j]+1: 
                        seq[i] = seq[j]+1
                        cnt[i] = cnt[j]
                    elif seq[i] == seq[j]+1:
                        cnt[i] += cnt[j]
                    # print(i, j, '-', nums[i], nums[j], '-', seq[i], seq[j])
                    # seq[i] = max(seq[i], seq[j]+1)

            # [1,3,5,4,7] - nums
            # [1,2,3,3,4] - seq
            # 1 0 - 3 1 - 2 1
            # 2 0 - 5 1 - 2 1
            # 2 1 - 5 3 - 3 2
            # 3 0 - 4 1 - 2 1
            # 3 1 - 4 3 - 3 2
            # 4 0 - 7 1 - 2 1
            # 4 1 - 7 3 - 3 2
            # 4 2 - 7 5 - 4 3 o
            # 4 3 - 7 4 - 4 3 o
        # print(cnt)

        max_lenth = max(seq)
        result = 0
        for i in range(n):
            if seq[i] == max_lenth:
                result += cnt[i] # 최대 길이일때의 cnt 합산

        return result