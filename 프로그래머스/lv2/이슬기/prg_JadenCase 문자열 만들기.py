def solution(s):
    str_arr = s.split(" ")
    #print(str_arr)
    for i in range(len(str_arr)):
        t = str_arr[i]
        if len(t) > 1:
            t = t[0].upper() + t[1:].lower()
        elif len(t) == 1:
            t = t[0].upper()
        str_arr[i] = t
    
    answer = " ".join(str_arr)
    
    return answer