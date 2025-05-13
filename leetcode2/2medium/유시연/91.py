class Solution:
    def numDecodings(self, s: str) -> int:
        n = len(s)
        new_str = ''
        count = 0

        for i in range(n):
            if int(str[i]) > 26 or int(str[i]) == 0:
                return 0
                break
            else:
                count += 1