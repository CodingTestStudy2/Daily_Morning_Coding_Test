class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        # must not convert the inputs to integers directly.
        
        # 뒷자리부터 하나씩 더하기
        n = len(num1) - 1 
        m = len(num2) - 1

        total = 0
        remain = 0
        result = ''

        while n >= 0 or m >= 0 or remain != 0:
            if n >= 0:
                n_asc = ord(num1[n]) - ord('0')
            else:
                n_asc = 0
            
            if m >= 0:
                m_asc = ord(num2[m]) - ord('0')
            else:
                m_asc = 0
            
            total = n_asc + m_asc + remain
            remain = total // 10
            result =  f'{total % 10}' + result

            # print(n_asc+0, m_asc+0, total, result, remain)
            n -= 1
            m -= 1

        return result
        