class Solution:
    def check_valid(self, num):
        return '0' not in str(num)
        
    def getNoZeroIntegers(self, n: int) -> List[int]:
        result = [0]*2

        # 가능한게 잇음 암거나 return해도 됨
        # 2^2 중에 0X

        # 10/ 101 같은거 안될거고...
        # 쪼개고 check_valid
        for a in range(1, n):
            b = n - a
            # print(a, b)
            if self.check_valid(a) and self.check_valid(b):
                return [a, b]