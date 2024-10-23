from itertools import product, permutations
    
res = 0
def dfs(numbers, target, n, dfs_sum):
    global res
    
    if n == len(numbers):
        if target == dfs_sum: 
            res += 1
        return 
    
    dfs(numbers, target, n+1, dfs_sum + numbers[n])
    dfs(numbers, target, n+1, dfs_sum - numbers[n])
    
    
def solution(numbers, target):
    # res = 0    
    # for i in list(product([-1,1],repeat=len(numbers))):
    #     each_sum = 0
    #     for idx, j in enumerate(i):
    #         each_sum += (j*numbers[idx])
    #     if each_sum == target:
    #         res += 1
    dfs(numbers, target, 0, 0)
    
    return res