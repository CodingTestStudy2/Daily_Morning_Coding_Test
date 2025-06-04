class Leetcode.이재훈.이재훈.Solution:
    def maximumOddBinaryNumber(self, s: str) -> str:
        result = []
        n = len(s)
        count = 0

        for i in range(n):
            if s[i] == '1' and count == 0:
                result.append('1')
                count +=1

            elif s[i] == '1' and count != 0:
                result.insert(0,'1')
            
            elif s[i] == '0':
                result.insert(len(result) - 1, '0')

        return ''.join(result)