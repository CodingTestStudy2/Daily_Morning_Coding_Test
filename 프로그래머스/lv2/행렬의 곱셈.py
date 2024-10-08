# https://school.programmers.co.kr/learn/courses/30/lessons/12949

def solution(arr1, arr2):
    # arr1행과 arr2열 (arr1열과 arr2행은 같을테니)
    n = len(arr1)
    m = len(arr1[0])
    k = len(arr2[0])
    
    answer = [[0] * k for _ in range(n)]
    
    for i in range(n):# arr1의 각 행
        for l in range(k):# arr2의 각 열
            for j in range(m):# arr1의 열과 arr2의 행 (공통 크기)
                answer[i][l] += arr1[i][j] * arr2[j][l]
    
    return answer