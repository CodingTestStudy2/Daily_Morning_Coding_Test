class Solution:
    def numMatchingSubseq(self, s: str, words: list[str]) -> int:      
        i, j = 0, 0
        count = 0
        for word in words:

            while i < len(word) and j < len(s):
                if word[i] == s[j]: 
                    i += 1
                j += 1 
            
            i == len(word) 
        
            if i == len(word): 
                count += 1
        
        return count
