def solution(s):
    answer = ''
    arr = list(s)
    for i in range(len(arr)):
        if i != 0 and arr[i-1] == ' ':
            arr[i] = arr[i].upper()
        elif i == 0 and not arr[i].isdigit():
            arr[i] = arr[i].upper()
        else:
            arr[i] = arr[i].lower()
    for i in range(len(arr)):
        answer += arr[i]
    return answer