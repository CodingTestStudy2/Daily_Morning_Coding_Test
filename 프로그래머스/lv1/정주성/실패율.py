def solution(N, stages):
    failure_rate_list = []
    total_user = len(stages)

    for stage in range(1, N + 1):
        if total_user > 0:
            standard_cnt = stages.count(stage)
            failure_rate = standard_cnt / total_user
            failure_rate_list.append((stage, failure_rate))

            stages = [x for x in stages if x != stage]
            total_user = len(stages)
        else:
            failure_rate_list.append((stage, 0))

    failure_rate_list.sort(key=lambda x: x[1], reverse=True)

    answer = [stage[0] for stage in failure_rate_list]

    return answer
