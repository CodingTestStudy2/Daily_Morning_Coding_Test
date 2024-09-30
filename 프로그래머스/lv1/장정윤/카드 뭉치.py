# https://school.programmers.co.kr/learn/courses/30/lessons/159994
def solution(cards1, cards2, goal):
    while len(goal) > 0:
        if len(cards1) > 0 and goal[0] == cards1[0]:
            cards1.pop(0)
            goal.pop(0)
        elif len(cards2) > 0 and goal[0] == cards2[0]:
            cards2.pop(0)
            goal.pop(0)
        else:
            return 'No'
    
    return 'Yes'