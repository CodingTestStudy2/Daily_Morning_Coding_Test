def solution(data, ext, val_ext, sort_by):
    idx_converter = {"code":0 , "date":1 , "maximum": 2, "remain": 3}
    answer = [d for d in data if d[idx_converter[ext]] < val_ext]
    answer.sort(key=lambda x : x[idx_converter[sort_by]])
    return answer