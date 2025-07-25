from collections import defaultdict
class Solution:
    def minimumSeconds(self, nums: List[int]) -> int:
        dic = defaultdict(list)
        for inx, v in enumerate(nums):
            dic[v].append(inx)

        n = len(nums)
        result = n

        key = dic.keys()
        for i in key:
            r = 0
            current = dic[i]
            ilen = len(current)
            for inx, j in enumerate(current):

                if inx == ilen -1:
                    r = max(int((current[0] + n - j) // 2), r)
                else:
                    r = max(int((current[inx+1] - j) // 2), r)

            result = min(r, result)
        
        return result