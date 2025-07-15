class Solution:
    def numOfSubarrays(self, arr: List[int]) -> int:
        MOD = 10**9+7
        n = len(arr)
        cnt_odd = 0
        cnt_even = 1
        sum = 0
        result = 0

        for num in arr:
            sum += num

            # 누적합이 짝수
            # 이전 합이 합짝+짝 / 합홀+홀 (같은거 더함)
            if sum % 2 == 0:
                if cnt_odd > 0:
                    # 아 근데 흠...
                    result += cnt_odd
                cnt_even += 1

            # 누적합이 홀수
            # 이전 합이 합홀+짝 / 합짝+홀(암튼 다른거 더함)
            else:
                if cnt_even > 0:
                    result += cnt_even
                cnt_odd += 1
            # print(num, sum, cnt_even, cnt_odd)

        return result % MOD

        # 전체 sub arr를 구한다. 
        # arr의 합을 구한다
        # 그 중 홀수인 합의 개수를 구한다.

        # 홀수가 홀수개 혹은 짝수+홀수로 합이 홀수인 세트

