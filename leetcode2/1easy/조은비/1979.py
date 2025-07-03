class Solution:
    def isThree(self, n: int) -> bool:
        # 1, m, n 이면 3개 인데.. m 이 소수
        if n <= 2:
            return False
        
        # m = 1 부터 10^2 중 소수
        m = int(n ** 0.5)
        if m * m != n:
            return False

        # m % (2부터 m-1까지 != 0) 면 소수 - true / 아니면 false
        for i in range(2, m-1):
            if m % i == 0:
                return False
        
        return True