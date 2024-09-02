def solution(s):
    arr = s.split(' ')
    arr = [int(i) for i in arr]
    print(arr)
    min_num = min(arr)
    max_num = max(arr)
    
    return str(min_num) + ' ' + str(max_num)