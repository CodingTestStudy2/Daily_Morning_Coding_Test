class Solution:
    def isPrefixString(self, s: str, words: List[str]) -> bool:
        ans = ""
        for word in words:
            ans += word
            if ans == s:
                return True
            if len(ans) > len(s):
                return False
        return False
