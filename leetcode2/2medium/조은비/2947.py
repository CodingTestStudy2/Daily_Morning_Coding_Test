class Solution:
    def beautifulSubstrings(self, s: str, k: int) -> int:
        # (모음 * 자음) % k == 0 만족 서브스트링
        VOWEL = ['a', 'e', 'i', 'o', 'u']
        result = 0
        v = 0
        c = 0

        # 길이가 2 이상, 각각 v / c 최소 1개 포함 substring
        # > 전체에서 vowel 을 먼저 찾고 substring 만들기
        # 개수만 세면 되는구나,,
        # [0,1,1,0,0]
        # [0,1,2,[4,2,1],[4,2]]
        n = len(s)
        for i in range(n):
            v = 0
            c = 0
            for k in range(i+1, n):
                sub = s[i:k]
                print(sub)

                if s[k] in VOWEL:
                    v+=1
                else:
                    c+=1
                
                if v>0 and c>0 and (v*c)%k == 0:
                    print(v, c, result)
                    result +=1

        return result