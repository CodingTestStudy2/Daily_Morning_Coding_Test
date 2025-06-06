class Leetcode.이재훈.이재훈.Solution:
    def countPrefixSuffixPairs(self, words: List[str]) -> int:
        count = 0
        n = len(words)
        
        for i in range(n):
            for j in range(i + 1, n):  # i < j 조건
                len1, len2 = len(words[i]), len(words[j])
                if len1 > len2:
                    continue

                if words[j][:len1] == words[i] and words[j][-len1:] == words[i]:
                    count += 1
        
        return count          
