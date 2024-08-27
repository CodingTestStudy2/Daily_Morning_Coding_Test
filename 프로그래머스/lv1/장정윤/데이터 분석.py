def solution(data, ext, val_ext, sort_by):
    answer = [[]]
    res = []
    # ext 기준으로 뽑아내기
    # sort_by에 해당하는 순으로 정렬
    item = ["code", "date", "maximum", "remain"]
    
    for i in range(len(data)):
        checkIdx = item.index(ext)
        if data[i][checkIdx] <= val_ext:
            res.append(data[i])
    checkIdx = item.index(sort_by)
    res.sort(key = lambda x: x[checkIdx])
    return res