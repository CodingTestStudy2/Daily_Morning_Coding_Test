class Solution:
    def countCompleteDayPairs(self, hours: list[int]) -> int:
        # 24의 배수 구하기
        # % 24 == 0 
        result = 0

        for i in range(0, len(hours)):
            for j in range(i+1, len(hours)):
                num = hours[i] + hours[j]
                if num % 24 == 0:
                    result += 1

        
        return result


if __name__ == '__main__':
    sol = Solution()

    print(sol.countCompleteDayPairs([12,12,30,24,24]))
    print(sol.countCompleteDayPairs([72,48,24,3]))