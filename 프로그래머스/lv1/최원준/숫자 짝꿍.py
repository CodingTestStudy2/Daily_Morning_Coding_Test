# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


from collections import Counter, deque
def solution(X, Y):
    nums = sorted([(k, v) for k, v in (Counter(X) & Counter(Y)).items()], reverse= True)
    ans = deque()
    for k, v in nums:
        for i in range(v):
            ans.append(k)

    while len(ans)>1 and ans[0] == "0":
        ans.popleft()
    return "".join(ans) if ans else "-1"