def captureForts(forts):
    max_cap = 0
    n = len(forts)
    
    for i in range(n):
        if forts[i] == 1 or forts[i] == -1:
            for j in range(n):
                if forts[j] == -1 or forts[j] == 1:
                    if i != j:
           
                        start, end = min(i, j), max(i, j)
    
    return max_cap
