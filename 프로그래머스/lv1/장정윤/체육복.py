# https://school.programmers.co.kr/learn/courses/30/lessons/42862
def solution(n, lost, reserve):
    
    # 여벌 가지고 있고, 다른 학생 빌려줄 수 있는 학생
    reserve_set = set(reserve) - set(lost)
    # 도난 당했고, 여벌이 없는 학생
    lost_set = set(lost) - set(reserve)
    
    for student in reserve_set:
        if student - 1 in lost_set:
            lost_set.remove(student - 1)
        elif student + 1 in lost_set:
            lost_set.remove(student + 1)      
    
    return n - len(lost_set)