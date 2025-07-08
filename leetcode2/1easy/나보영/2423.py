
from collections import Counter

class Solution:
    def equalFrequency(self, word: str) -> bool:
        dic = Counter(word)

        k = list(dic.keys())

        for i in k:
            dic[i] -= 1
            if dic[i] == 0:
                del dic[i]

            if len(set(dic.values())) == 1:
                return True
            
            if i in dic:
                dic[i] += 1
            else:
                dic[i] = 1

        return False