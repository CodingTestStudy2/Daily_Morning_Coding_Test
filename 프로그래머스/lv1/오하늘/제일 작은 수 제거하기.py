def solution(arr):
    m = min(arr)
    arr.remove(m)
    
    if len(arr) == 0:
        return [-1]
    
    return arr