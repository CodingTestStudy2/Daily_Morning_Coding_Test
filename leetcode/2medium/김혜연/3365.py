<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def isPossibleToRearrange(self, s: str, t: str, k: int) -> bool:
        slen = len(s)

        l = 0
        r = (slen)//k

        d = {}

        while(r <= slen):
            substr = s[l:r]
            
            if substr in d:
                d[substr] += 1
            else :
                d[substr] = 1

            l += (slen)//k
            r += (slen)//k

        l = 0
        r = (slen)//k

        while(r <= slen):
            substr = t[l:r]

            if substr not in d :
                return False

            d[t[l:r]] -= 1

            if d[substr] == 0:
                del d[substr]

            l += (slen)//k
            r += (slen)//k

        return 1