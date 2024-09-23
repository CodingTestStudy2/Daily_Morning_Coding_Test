# https://school.programmers.co.kr/learn/courses/30/lessons/42579

def solution(genres, plays):
    answer = []
    dic = {}
    # 재생 많은 장르 > 장르 내 재생 많은 순 > 고유 번호 낮은순
    # 장르 genres, 재생 횟수 plays
    # genres[i] => i 고유번호, genres[i]: 장르
    
    for i in range(len(genres)):
        if genres[i] in dic.keys():        
            dic[genres[i]][0] += plays[i]
            dic[genres[i]][1].append(plays[i])
        else: 
            dic[genres[i]] = [plays[i], [plays[i]]]
    sorted_genres = sorted(dic.items(), key=lambda x: x[1][0], reverse = True)
    
    print(sorted_genres)

    return answer
