def solution(ingredient):
    answer = 0
    burger = []
    for i in ingredient:
        burger.append(i)
        if len(burger) >= 4 and burger[-4:] == [1,2,3,1]:
            for j in range(4):
                burger.pop()
            answer += 1
    return answer