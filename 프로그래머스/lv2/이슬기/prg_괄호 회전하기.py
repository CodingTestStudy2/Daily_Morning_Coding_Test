'''
deque에 넣고 하나씩 빼서 검사하면...
최악의 시간복잡도 1,000 * 1,000 = 1,000,000
괜찮겠다^^
'''
from collections import deque

def solution(s):
    answer = 0
    q = deque(list(s))
    n = len(s)
    
    def is_blank(q):
        q_str = ''.join(q)
        stack = []
        # print(q_str)
        for i in range(n):
            now = q_str[i]
            if not stack: # 스택이 비었으면
                if now == "{" or now == "[" or now == "(":
                    stack.append(now)
                    continue
                else:
                    return False
            
            if now == "{" or now == "[" or now == "(":
                stack.append(now)
            elif now == "}" and stack[-1] == "{":
                stack.pop()
            elif now == "]" and stack[-1] == "[":
                stack.pop()
            elif now == ")" and stack[-1] == "(":
                stack.pop()
            else:
                return False
        
        return False if stack else True
    
    for _ in range(n):
        if is_blank(q):
            answer += 1
        q.rotate(-1)
    
    return answer