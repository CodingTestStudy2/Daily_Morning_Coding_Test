'''
[7, 9, 1, 1, 4]
=> [7, 9], [9, 1], [1, 1], [1, 4], ...
"연속된 부분 수열" -> 슬라이딩 윈도우
'''

def solution(elements):
    n = len(elements)
    elements += elements # 원형
    num_set = set()
    
    for i in range(1, n+1): # window 크기 정하기
        window = sum(elements[:i])
        num_set.add(window)
        for j in range(i, len(elements)):
            window += elements[j] - elements[j-i]
            num_set.add(window)
    
    return len(num_set)