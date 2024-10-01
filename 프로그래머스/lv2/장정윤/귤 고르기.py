# https://school.programmers.co.kr/learn/courses/30/lessons/138476

# 15분
# k 개를 골라 상자에 담기.
# 서로 다른 귤 크기를 최소화할 것.
# 크기별 개수 카운팅, 카운팅이 큰거부터 넣어 6개 맞추기
def solution(k, tangerine):
    answer = 0
    cnt = 0
    size_dic = {}
    
    for item_size in list(set(tangerine)):
        size_dic[item_size] = 0        
    
    for idx, item in enumerate(tangerine):
        size_dic[item] += 1
    
    # dic 큰 순으로 정렬
    for num in sorted(size_dic.values(), reverse=True):
        if k > 0:
            k -= num
            cnt += 1
        else:
            return cnt
    return cnt