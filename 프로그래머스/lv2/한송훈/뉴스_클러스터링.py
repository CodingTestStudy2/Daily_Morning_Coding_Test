from collections import Counter

def solution(str1, str2):
    ## 합 : 개수 - 교집합 개수
    # 길이 1000 이하
    li_1, li_2 = [], []
    for i in range(len(str1)-1):
        if str1[i:i+2].isalpha(): li_1.append(str1[i:i+2].upper())
    for i in range(len(str2)-1):
        if str2[i:i+2].isalpha(): li_2.append(str2[i:i+2].upper())
    
    # 각 원소의 개수를 세기 위해 Counter 사용
    counter_1 = Counter(li_1)
    counter_2 = Counter(li_2)
    
    inter = list((counter_1 & counter_2).elements())
    union = list((counter_1 | counter_2).elements())
    
    if len(union) == 0:
        return 65536
    else:
        return int(len(inter) / len(union) * 65536)