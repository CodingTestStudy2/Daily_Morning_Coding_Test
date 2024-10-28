def solution(topping):
    res = 0
    left_topping_value = [0 for i in range(len(topping))]
    right_topping_value = [0 for i in range(len(topping))]
    left_set = set()
    right_set = set()

    for i in range(len(topping)):
        left_set.add(topping[i])
        left_topping_value[i] = len(left_set)
        
    for i in range(len(topping)-1,-1,-1):
        right_set.add(topping[i])
        right_topping_value[i] = len(right_set)
        
    for i in range(len(topping) - 1):
        # [1, 2, 3, 4, 5] / [5, 4, 3, 2, 1]
        if left_topping_value[i] == right_topping_value[i+1]:
            res += 1 
    return res    
    
    
# def solution(topping):
#     res = 0
    
#     old = dict()
#     young = dict()
    
#     for i in topping:
#         if i in old:
#             old[i] += 1
#         else:
#             old[i] = 1
    
#     for i in topping:
#         old[i] -= 1
#         if i in young:
#             young[i] += 1
#         else:
#             young[i] = 1
        
#         if old[i] == 0:
#             old.pop(i)
#         if len(old.keys()) == len(young.keys()):
#             res+=1

#     return res
