# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


from collections import defaultdict, deque
import heapq
def solution(n, cores):



    if n <= len(cores):
        return n

    n -= len(cores)

    def get_completed(time): #모든 코어가 해당 시간안에 완료할 수 있는 task합
        ans = 0
        for core in cores:
            ans += time // core
        return ans

    left, right = 1, max(cores) * n
    while left < right:
        mid = (left + right) // 2
        completed_tasks = get_completed(mid)

        if completed_tasks >= n: #모든 작업 완료 가능
            right = mid
        else:
            left = mid + 1

    completed = get_completed(left-1)
    remaining = n - completed

    for i, core in enumerate(cores):
        if left % core == 0: #해당 시간에 포함되는 코어
            remaining -= 1
            if remaining == 0:
                return i + 1


    '''
    # 시간초과
    time_dict = defaultdict(int)
    for i, num in enumerate(cores):
        time_dict[i] = num
    # print(time_dict)
    
    dict = defaultdict(list)
    for i in range(len(cores)):
        dict[0].append(i)
    print(dict)

    idx = 0
    while n:
        available = dict[idx]
        if n > len(available):
            n -= len(available)
            for core in available:
                dict[idx+time_dict[core]].append(core)
            # print(n, dict)
        elif n <= len(available):
            print(available)
            available.sort()
            return available[n-1] + 1
        idx+=1



    return -1

    # 시간초과
    wait = [(0, i) for i in range(len(cores))] # time, core

    while n:
        time, core = heapq.heappop(wait)
        heapq.heappush(wait, (time+time_dict[core], core))
        n-=1

    return core+1



    # 시간초과
    available = [] # core, time
    curr_time = 0
    while n:
        while wait and wait[0][0] <= curr_time:
            time, core = heapq.heappop(wait)
            available.append((time, core))
            # heapq.heappush(available, (core, time))

        while available and n:
            if n > len(available):
                n -= len(available)
                while available:
                    time, core = available.pop()
                    heapq.heappush(wait, (curr_time + time_dict[core], core))

            elif n<=len(available):
                available.sort(key = lambda x: x[1])
                return available[n-1][1]+1

        curr_time += 1

    answer = 0
    return answer
    '''