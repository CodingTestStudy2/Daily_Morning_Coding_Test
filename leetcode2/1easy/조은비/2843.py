class Solution:
    def check_sym(self, num):
        s_num = str(num)
        n = len(s_num)
        if n % 2 != 0:
            return False
        
        half = n // 2
        
        if sum(map(int, s_num[:half])) == sum(map(int, s_num[half:])):
            # print(num, sum(map(int, s_num[:half])))
            return True

        return False

    def countSymmetricIntegers(self, low: int, high: int) -> int:
        cnt = 0

        # 앞자리 절반이랑 뒷자리 절반의 합이 같은지 체크
        for num in range(low, high+1):
            if self.check_sym(num):
                cnt += 1
            
        return cnt