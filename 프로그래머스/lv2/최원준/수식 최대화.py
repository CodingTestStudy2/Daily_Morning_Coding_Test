# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


from itertools import permutations
from collections import deque
def solution(expression):
    '''
    100-200*300-500+20
    100-200*300-520
    -100*-220
    22000
    '''

    def separate(expression):
        stack = []
        temp = ""
        for c in expression:
            if c in "+-*":
                stack.append(int(temp))
                temp = ""
                stack.append(c)
            else:
                temp+=c
        stack.append(int(temp))
        return stack

    def calc_value(left, right, op):
        return left+right if op == "+" else left-right if op == "-" else left*right

    def calc(operator, formula):
        formula = deque(formula)
        stack = []
        while formula:
            curr = formula.popleft()
            if curr == operator:
                left = stack.pop()
                right = formula.popleft()
                stack.append(calc_value(left, right, curr))
            else:
                stack.append(curr)
        return stack

    operators = ["+", "-", "*"]
    expression_list = separate(expression)
    ans = 0
    for perm in permutations(operators,3):
        temp_list = expression_list
        for operation in perm:
            temp_list = calc(operation, temp_list)
        ans = max(ans, abs(temp_list[0]))
    return ans