def solution(s):
    s_list = sorted(list(s), reverse=True)
    
    return "".join(s_list)