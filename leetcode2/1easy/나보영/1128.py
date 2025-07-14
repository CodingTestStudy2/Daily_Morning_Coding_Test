from collections import Counter

class Solution:
    def numEquivDominoPairs(self, dominoes: List[List[int]]) -> int:
        dic = Counter()
        result = 0
        for a, b in dominoes:
            if a < b:
                result += dic[(a, b)]
                dic[(a, b)] += 1
            else:
                result += dic[(b, a)]
                dic[(b, a)] += 1
        
        return result