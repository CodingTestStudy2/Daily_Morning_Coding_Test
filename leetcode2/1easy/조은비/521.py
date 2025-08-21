class Solution:
    def findLUSlength(self, a: str, b: str) -> int:
        # 가장 긴 subseq
        # no uncommon sub => reutrn -1
        
        # ?? common uncommon 구분이 뭐지
        # 본인만 가지는 substring?
        # 주복 sub나오면 -1
                
        n = len(a)
        m = len(b)

        if a == b:
            return -1
        return max(n,m)

