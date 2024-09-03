import sys
sys.setrecursionlimit(10**6)


def find(r_n, room_dict):
    if r_n not in room_dict:
        room_dict[r_n] = r_n + 1
        return r_n
    empty = find(room_dict[r_n], room_dict)
    room_dict[r_n] = empty + 1
    return empty


def solution(k, room_number):
    answer = []

    room_dict = dict()
    for r_n in room_number:
        answer.append(find(r_n, room_dict))

    return answer

# [1, 3, 4, 2, 5, 6]
print(solution(10, [1, 3, 4, 1, 3, 1])) # 	[1, 3, 4, 2, 5, 6]