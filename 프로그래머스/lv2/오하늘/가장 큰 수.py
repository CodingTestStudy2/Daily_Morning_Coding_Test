def solution(numbers):
    numbers = sorted(numbers, key=lambda x: str(x)*3, reverse=True)
    answer = ''.join(map(str, numbers))
    if int(answer) == 0 : return "0"
    return answer

print(solution([3, 30, 34, 5, 9]))