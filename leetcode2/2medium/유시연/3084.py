class Leetcode.이재훈.이재훈.Solution:
    def countSubstrings(self, s: str, c: str) -> int:
        count = s.count(c)
        answer = count * (count + 1) // 2 #조합공식

        return answer