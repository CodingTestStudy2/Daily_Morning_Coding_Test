# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


import sys
sys.setrecursionlimit(10**6)

def solution(k, room_number):
    next_room_map = {}

    def get_room(x):
        if x not in next_room_map:
            next_room_map[x] = x + 1
            return x

        next_room = get_room(next_room_map[x])
        next_room_map[x] = next_room
        return next_room


    return [get_room(n-1) + 1 for n in room_number]