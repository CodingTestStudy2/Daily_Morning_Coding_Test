# https://school.programmers.co.kr/learn/courses/30/lessons/42840
def solution(answers):
    user_1 = [1, 2, 3, 4, 5]
    user_2 = [2, 1, 2, 3, 2, 4, 2, 5]
    user_3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    sum_list = [0, 0, 0]
    
    for i in range(len(answers)):
        if answers[i] == user_1[i % len(user_1)]:
            sum_list[0] += 1
        if answers[i] == user_2[i % len(user_2)]:
            sum_list[1] += 1
        if answers[i] == user_3[i % len(user_3)]:
            sum_list[2] += 1
    
    # 최고 점수
    max_score = max(sum_list)

    # 최고 점수를 가진 사용자 반환
    return [i + 1 for i, score in enumerate(sum_list) if score == max_score]
