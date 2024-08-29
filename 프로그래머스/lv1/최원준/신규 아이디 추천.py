# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


def solution(new_id):
    candid = "abcdefghijklmnopqrstuvwxyz0123456789-_."
    #1
    id = new_id.lower()
    #2
    id = "".join([c for c in id if c in candid])
    #3
    while ".." in id:
        id = id.replace("..",".")
    #4
    if id and id[0] == ".":
        id = id[1:]
    if id and id[-1] == ".":
        id = id[:-1]
    # 5
    if not id:
        id = "a"
    #6
    id = id[:15]
    if id and id[-1] == ".":
        id = id[:-1]
    #7
    while len(id) < 3:
        id += id[-1]
    return id