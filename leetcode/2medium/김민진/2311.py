# memory limit exceeded (52 / 153 testcases passed)

<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def __init__(self):
        self.s = None
        self.k = None
        self.memo = {}
    
    def dfs(self, idx, substring):
        if (idx, substring) in self.memo:
            return self.memo[(idx, substring)]
        if idx < 0:
            return 0
        
        if int(self.s[idx] + substring, 2) <= self.k:
            s1 = self.dfs(idx - 1, self.s[idx] + substring) + 1
            s2 = self.dfs(idx - 1, substring)
            return_value = max(s1, s2)
        else:
            return_value = self.s[:idx].count("0")
        self.memo[(idx, substring)] = return_value

        return return_value

    def longestSubsequence(self, s: str, k: int) -> int:
        self.s = s
        self.k = k
        return self.dfs(len(s)-1, "")