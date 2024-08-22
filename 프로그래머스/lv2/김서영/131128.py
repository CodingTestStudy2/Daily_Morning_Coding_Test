def solution(X, Y):
    from collections import Counter
    
    x_cnt = Counter(X)
    y_cnt = Counter(Y)
    print(x_cnt, y_cnt)
    pair_candidate = []
    for x_key in x_cnt.keys():
        if x_key in y_cnt.keys():
            pair_candidate += [x_key] * min(x_cnt[x_key], y_cnt[x_key])
    pair_candidate.sort(reverse=True)
    if len(pair_candidate) == 0: return '-1'
    if pair_candidate[0] == pair_candidate[-1] == '0': return '0'
    return ''.join(pair_candidate)