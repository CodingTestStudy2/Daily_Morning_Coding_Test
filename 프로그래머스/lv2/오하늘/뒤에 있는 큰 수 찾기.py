# 가장 가까이 큰 수가 핵심
# 스택으로 접근해보았으나 시간 초과..
def solution(numbers):
    answer = [-1]

    stack = [numbers[len(numbers)-1]]
    for i in range(len(numbers)-2,-1,-1):

        while stack and numbers[i] >= stack[-1]:
            stack.pop() # 작은 경우만 pop

        if stack:
            answer.insert(0,stack[-1])
        else:
            answer.insert(0,-1)

        stack.append(numbers[i])
            
    return answer

print(solution([9, 1, 5, 3, 6, 2]))