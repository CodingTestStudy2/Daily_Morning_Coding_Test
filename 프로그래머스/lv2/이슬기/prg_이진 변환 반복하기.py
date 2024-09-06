'''
이진 변환 함수 찾아봤음
format(s, 'b')
bin(s)
'''

def solution(s):
    answer = [0, 0]
    
    while True:
        if s == '1':
            break
        answer[1] += s.count('0') # 0의 개수 추가
        s = s.replace('0', '')
        s = str(format(len(s), 'b'))
        answer[0] += 1
    
    return answer