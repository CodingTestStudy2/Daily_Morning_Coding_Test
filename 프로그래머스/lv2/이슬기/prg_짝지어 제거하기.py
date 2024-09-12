'''
1. 두 개가 동시에 붙어있는 문자 찾기
2. 제거해서 다시 붙이기
-> 반복
-> 효율성 문제

-- 두번째 풀이
stack을 사용해서 풀기 -> 같은 알파벳이 "2개" 붙어있는 짝을 찾는 것이므로 스택사용해도 좋음
'''
def solution(s):
    stack = [s[0]]
    
    for i in range(1, len(s)):
        if len(stack) == 0:
            stack.append(s[i])
        elif stack[-1] == s[i]:
            pre = stack.pop()
        else:
            stack.append(s[i])
    
    return 0 if stack else 1