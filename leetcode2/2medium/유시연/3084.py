class Solution:
    def countSubstrings(self, s: str, c: str) -> int:
        count = s.count(c)
        answer = count * (count + 1) // 2 #조합공식

        return answer