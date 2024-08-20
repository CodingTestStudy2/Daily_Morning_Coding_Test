# https://school.programmers.co.kr/learn/courses/30/lessons/67257

import re
from itertools import permutations

def solution(expression):
    numbers = list(map(int, re.findall(r'\d+', expression)))
    operators = re.findall(r'[\+\-\*]', expression)
    operator_priorities = list(permutations(['+', '-', '*']))
    answer = 0
    for operator in operator_priorities:
        result = calculate(operator, numbers[:], operators[:])
        answer = max(answer, abs(result))
    return answer

def calculate(operator, numbers, operators):
    if not operator:
        return numbers[0]
    current_operator = operator[0]
    while current_operator in operators:
        idx = operators.index(current_operator)
        if current_operator == '-':
            numbers[idx] -= numbers[idx+1]
        elif current_operator == '+':
            numbers[idx] += numbers[idx+1]
        elif current_operator == '*':
            numbers[idx] *= numbers[idx+1]
        del numbers[idx+1]
        del operators[idx]
    return calculate(operator[1:], numbers, operators)

print(solution("100-200*300-500+20"))
