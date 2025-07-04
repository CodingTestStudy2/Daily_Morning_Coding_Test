class Solution:
    def checkIsPrime(self, num: int) -> bool:
        if num < 2: 
            return False
        for i in range(2, int(num**0.5)+1 ):
            if num % i == 0:
                return False
        return True

    def sumOfLargestPrimes(self, s: str) -> int:
        # s로부터 formating numbers 얻기
        # nums = []
        result = set()
        n = len(s)

        for i in range(n):
            for j in range(i+1, n+1):
                # s = "2" 등 한글자..
                num = int(s[i:j])
                if self.checkIsPrime(num):
                    result.add(num)
        
        # # 소수인지 체크
                
        l = sorted(result)
        return sum(l[-3:])