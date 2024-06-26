from collections import deque

# 스택을 이용한 올바른 괄호 문자열 판별
def is_correct_string(w):
    s = []

    for i in range(len(w)):
        if w[i] == '{' or w[i] == '[' or w[i] == '(':
            s.append(w[i])
        else:
            if not s:
                return False
            top = s.pop()
            if w[i] == ']' and top != '[':
                return False
            if w[i] == '}' and top != '{':
                return False
            if w[i] == ')' and top != '(':
                return False

    if len(s) > 0:
        return False
    return True

# 큐를 사용하여 모든 회전 경우의 수에 대하여 올바른 괄호 문자열 개수 카운트
def solution(s):
    answer = 0
    w = deque(s)

    for i in range(len(s)):
        if is_correct_string(w):
            answer += 1
        w.append(w.popleft())

    return answer