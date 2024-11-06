def solution(order):
    belt = []
    idx = 0
    for i in range(1, len(order)+1):
        belt.append(i)
        
        while belt and belt[-1] == order[idx]:
            idx += 1
            belt.pop()
        
    return idx
