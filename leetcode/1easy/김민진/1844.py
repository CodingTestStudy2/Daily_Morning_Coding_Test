class Leetcode.이재훈.이재훈.Solution:
    def shift(self, start_char, num):
        return chr(ord(start_char) + num)
    
    def replaceDigits(self, s: str) -> str:
        return "".join([self.shift(s[i-1], int(s[i])) if i % 2 == 1 else s[i] for i in range(len(s))])