# https://school.programmers.co.kr/learn/courses/30/lessons/72410

import re

def solution(new_id):
    new_id = new_id.lower()
    answer = ''
    for i in new_id:
        if i.isalpha() or i.isnumeric() or i == '-' or i == '_' or i == '.':
            answer += i
    answer = re.sub(r'\.+', '.', answer)
    if len(answer) != 0 and answer[0] == '.':
        answer = answer[1:]
    if len(answer) != 0 and answer[-1] == '.':
        answer = answer[:-1]
    if not answer:
        answer = 'a'
    if len(answer) >= 16:
        if answer[14] == '.':
            answer = answer[:14]
        else: 
            answer = answer[:15]
    if len(answer) <= 2:
        last = answer[-1]
        for i in range(3 - len(answer)):
            answer += last
    return answer