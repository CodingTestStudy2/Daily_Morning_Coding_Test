<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def secondsToRemoveOccurrences(self, s: str) -> int:
        # 문제 이해 : 01이 사라질때까지 01 -> 10 으로 변경
        ans = 0
        flag = 0 # break 조건

        s=list(s)
        while True:
            idx = 0
            while idx<len(s)-1:
                if s[idx] == "0" and s[idx+1] == "1":
                    flag = 1 # 바뀜
                    s[idx] = "1"
                    s[idx+1] = "0"
                    idx+=2
                else: idx +=1
            if flag == 0:
                return ans
            flag = 0
            ans+=1
