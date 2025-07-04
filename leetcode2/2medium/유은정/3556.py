class Solution(object):
    def isPrime(self, num):
        if num == 2:
            return True
        if num == 1 or num % 2 == 0:
            return False
        for d in range(3, int(num**0.5) + 1, 2):
            if num % d == 0:
                return False
        return True

    def sumOfLargestPrimes(self, s):
        len_word = len(s)

        # 0. 중복 값 제거 위해 set으로 선언
        primes = set()
        numbers = set()

        # 1. 숫자 자르기
        for i in range(0, len_word):
            num = 0
            for j in range(i, len_word):
                num = num * 10 + int(s[j])
                if num < 2:
                    continue
                # 2. 소수 판별
                if self.isPrime(num):
                    primes.add(num)
                
        # 3. set을 list로 변경 후 정렬
        primes = list(primes)
                
        # 4. 가장 큰 수 3개의 합 
        tops = sorted(primes)[-3:]
        return sum(tops)