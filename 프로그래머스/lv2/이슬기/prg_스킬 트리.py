'''
가능한 스킬 트리
동일한 순서가 나와야 함!
'''

def solution(skill, skill_trees):
    answer = 0
    
    for item in skill_trees:
        skill_arr = list(skill)
        is_Ok = True
        # 하나씩 검사하기
        for i in range(len(item)):
            if item[i] in skill_arr:
                if skill_arr[0] != item[i]:
                    is_Ok = False
                    break
                else:
                    skill_arr.pop(0)
        if is_Ok:
            answer += 1
    
    return answer