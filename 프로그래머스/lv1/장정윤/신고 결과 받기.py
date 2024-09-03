def solution(id_list, report, k):
    answer = [0] * len(id_list)
    cnt = [0] * len(id_list)
    hash_map = {id_list[i]: i for i in range(len(id_list))}
    attack = []
    receive = []

    report = list(set(report))

    for rep in report:
        reportList = rep.split(' ')
        attack.append(reportList[0])
        receive.append(reportList[1])
        cnt[hash_map[reportList[1]]] += 1

    return answer
