def solution(skill, skill_trees):
    answer = 0
    
    for skill_tree in skill_trees:
        skill_list = []
        for i in skill:
            flag = True
            for idx, j in enumerate(skill_tree):
                if i == j: 
                    skill_list.append(idx)
                    flag = False
            if flag: skill_list.append(999)
        if skill_list == sorted(skill_list): answer += 1
    
    return answer