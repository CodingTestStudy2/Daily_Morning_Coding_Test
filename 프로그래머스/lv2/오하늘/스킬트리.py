from collections import deque

def solution(skill, skill_trees):
    answer = 0
    
    for i in range(len(skill_trees)):
        tmp = deque(skill)
        
        flag = 0
        for sk in skill_trees[i]:
            if sk in skill: # 스킬이 문자열 안에 있으면
                if sk == tmp[0]: # 첫번째 스킬과 같으면
                    tmp.popleft()
                else : # 스킬이 문자열에 없는데 스킬도 다름
                    flag = 1
                    break
        if flag != 1:
            answer += 1
    
    return answer

print(solution("CBD", ["BACDE", "CBADF", "AECB", "BDA"]))