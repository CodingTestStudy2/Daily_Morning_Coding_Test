<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
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
