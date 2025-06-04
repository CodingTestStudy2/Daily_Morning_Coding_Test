class Leetcode.이재훈.이재훈.Solution:
    def isPrefixString(self, s: str, words: List[str]) -> bool:
        s2 = ""
        i = 0

        while len(s2) < len(s) and i < len(words):
            s2 += words[i]
            i += 1
        
        return s2 == s 