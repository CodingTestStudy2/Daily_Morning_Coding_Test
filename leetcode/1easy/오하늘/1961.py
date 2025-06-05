<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def isPrefixString(self, s: str, words: List[str]) -> bool:
        ans = ""
        for word in words:
            ans += word
            if ans == s:
                return True
            if len(ans) > len(s):
                return False
        return False
