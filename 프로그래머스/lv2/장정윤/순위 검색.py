# 완성 x
def solution(info, query):
    answer = []
    query_copy = []
    info_copy = []
    # ['java', 'backend', 'junior', 'pizza 100'
    # 하나라도 다르면 break, - 이면 통과
    for j in range(len(info)):
        query_copy = query[i].split(" and ")
        for i in range(len(info)):
            is_valid = True
            info_copy = info[i].split(' ')
            for i in range(len(info_copy)):
                if info_copy[i] == '-':
                    return
                else:
                    if info_copy[i] == query_copy[i]:
                        return
                    else:
                        is_valid = False
                        break
                if is_valid:
                    answer.append(info[i])
    return answer

    