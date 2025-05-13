class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        count = 0

        for word in words:
            i, j = 0, 0
            while i < len(word) and j < len(s):
                if word[i] == s[j]: 
                    i += 1
                j += 1 

            if i == len(word): 
                    count += 1
                
        
        return count
