def solution(n):
    answer = ''
    
    k = n//2
    answer = "수박"*k
    if n%2 != 0:
        answer+="수"
        
    return answer