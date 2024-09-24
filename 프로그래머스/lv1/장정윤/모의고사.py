# https://school.programmers.co.kr/learn/courses/30/lessons/42840
def solution(answers):
    answer = []
    
    user_1 = [1, 2, 3, 4, 5]
    user_2 = [2, 1, 2, 3, 2, 4, 2, 5]
    user_3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    dic_check = {1: [],2: [], 3: []}
    sum_list = [0,0,0]
    
    for i in range(len(answers)):
        if answers[i] == user_1[i % len(user_1)]:
            dic_check[1].append(1)
        else:
            dic_check[1].append(0)
        
        if answers[i] == user_2[i % len(user_2)]:
            dic_check[2].append(1)
        else:
            dic_check[2].append(0)
            
        if answers[i] == user_3[i % len(user_3)]:
            dic_check[3].append(1)
        else:
            dic_check[3].append(0)
    
        
    for i in range(len(dic_check.keys())):
        sum_list[i] = sum(dic_check[i+1])
        
    max_score = max(sum_list)        

    for i in range(len(sum_list)):        
        if max_score == sum_list[i]:
                answer.append(i+1)
    
    return answer