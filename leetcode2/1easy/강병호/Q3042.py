class Leetcode.이재훈.이재훈.Solution:
    def countPrefixSuffixPairs(self, words: list[str]) -> int:
        n = len(words)
        count = 0

        for i in range(n):
            for j in range(i + 1, n):
                if self.isPrefixAndSuffix(words[i], words[j]):
                    count += 1
        
        return count

    def isPrefixAndSuffix(self, str1: str, str2: str) -> bool:
        return str2.startswith(str1) and str2.endswith(str1)
