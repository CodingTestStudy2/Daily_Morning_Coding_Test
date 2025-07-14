class Solution:
    def numEquivDominoPairs(self, dominoes: List[List[int]]) -> int:
        # list[0] == list2[1]과 동일
        n = len(dominoes)
        result = 0

        pair = {}

        for a, b in dominoes:
            dom = f'{str(sorted((a,b)))}'
            
            if dom in pair:
                result += pair[dom]
                pair[dom] += 1
            else:
                pair[dom] = 1
            # print(pair)
            
        return result