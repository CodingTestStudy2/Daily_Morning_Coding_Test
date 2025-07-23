
from collections import defaultdict
class Solution:
    def maxSumDistinctTriplet(self, x: List[int], y: List[int]) -> int:
        dic= defaultdict(int)
        for inx, v in enumerate(y):
            if dic[x[inx]]:
                dic[x[inx]] = max(dic[x[inx]], v)
            else:
                dic[x[inx]] = v
            
        if len(dic.keys()) >= 3:
            c = list(dic.values())
            c.sort(reverse = True)
            return sum(c[:3])
        else:
            return -1