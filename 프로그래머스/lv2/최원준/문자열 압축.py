# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


from collections import deque
def solution(s):
    n = len(s)
    ans = n

    for size in range(1, len(s)//2 + 1):
        sstring = ""
        strings = deque([s[i:i+size] for i in range(0, n, size)])
        while strings:
            if len(strings[0]) != size:
                sstring+=strings.popleft()
            else:
                count = 1
                base = strings.popleft()
                while strings and strings[0] == base:
                    strings.popleft()
                    count += 1
                if count > 1:
                    sstring += str(count)
                sstring +=base
        # print(sstring)
        ans = min(ans, len(sstring))
    return ans