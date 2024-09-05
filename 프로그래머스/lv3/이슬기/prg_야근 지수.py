'''
가장 큰 수부터 작업 처리하기
  1   0
[4, 3, 3] -> [3, 3, 3]
  3   1
[5, 2, 1] 3 + 1 * 2
  0   1
[2, 2, 1] 
'''

def solution(n, works):
    answer = 0
    works.sort(reverse=True)
    
    for w in range(len(works)-1):
        cnt = (works[w] - works[w+1]) * (w+1)
        if cnt > 0 and n > 0:
            if n - cnt >= 0:
                n -= cnt
                works[:w+2] = [works[w+1]] * (w+2)
            else:
                break
    
    if n > 0:
        gap = n // len(works)
        remain = n % len(works)
        for j in range(len(works)):
            if works[j] - gap >= 0:
                works[j] -= gap
            else:
                works[j] = 0
                works.sort(reverse=True)
        if remain != 0:
            for j in range(remain):
                if works[j] > 0:
                    works[j] -= 1
    
    print(works, n)
    answer = sum(list(i*i for i in works))
    
    return answer