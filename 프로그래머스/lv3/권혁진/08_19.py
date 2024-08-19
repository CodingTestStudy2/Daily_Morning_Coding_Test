# https://school.programmers.co.kr/learn/courses/30/lessons/70130

from collections import Counter

def solution(a):
    if len(a) < 2: return 0
    a_count = Counter(a)
    max_length = 0
    for num in a_count:
        if a_count[num] * 2 <= max_length: continue
        length = 0
        i = 0
        while i < len(a) - 1:
            if (a[i] == num and a[i+1] != num) or (a[i] != num and a[i+1] == num):
                length += 2
                i += 2
            else: i += 1
        max_length = max(max_length, length)
    return max_length

# print(solution([5,2,3,3,5,3]))
print(solution([0,3,3,0,7,2,0,2,2,0]))