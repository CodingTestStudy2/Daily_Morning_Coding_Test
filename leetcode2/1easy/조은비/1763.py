class Solution:
    def longestNiceSubstring(self, s: str) -> str:
        # 대소문자가 존재 / 이중 가장 긴거
        if len(s) < 2:
            return ""

        