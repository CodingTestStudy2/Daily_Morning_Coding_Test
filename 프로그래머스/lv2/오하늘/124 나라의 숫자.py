# 3진법이라는 과정 보고 재 풀이
def solution(n):
    answer = ''
    arr = ['1','2','4'] # 3으로 나눴을때 인덱스가 나와야함
    while n > 0 :
        n=n-1 # -1을 해주면 각 0,1,2가 나옴
        answer = arr[n%3]+answer
        n//=3
    
    return answer