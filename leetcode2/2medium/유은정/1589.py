class Solution(object):
    def maxSumRangeQuery(self, nums, requests):
        num_length = len(nums)
        count = [0] * num_length
        
        # 1. start, end 인덱스 정보 기록
        # count = [0, 1, 0, 0, -1, 0]
        #             ↑         ↑
        #          +1 시작     +1 종료
        for start, end in requests:
            count[start] += 1
            if end + 1 < num_length:
                count[end+1] -= 1

        # 2. 누적합 계산
        #count = [0, 1, 1, 1, 0]
        for i in range(1, num_length):
            count[i] += count[i-1]

        # 3. 큰 값 순서대로 정렬
        nums.sort(reverse = True)
        count.sort(reverse = True)

        # 4. 최종 값 계산
        sum = 0
        for i in range(len(nums)-1, -1, -1):
            sum += nums[i] * count[i]

        return sum % (10**9 + 7)

        
