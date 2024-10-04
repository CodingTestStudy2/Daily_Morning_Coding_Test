'''
이진수
[9, 20, 28, 18, 11] => [01001, 10100, 11100, 10010, 01011]
'''

def solution(n, arr1, arr2):
    answer = []
    map1 = ["" for _ in range(n)]
    map2 = ["" for _ in range(n)]
    
    for i in range(n):
        res1 = format(arr1[i], 'b')
        res1 = str(res1) if len(str(res1)) >= n else "0" * (n - len(str(res1))) + str(res1)
        res2 = format(arr2[i], 'b')
        res2 = str(res2) if len(str(res2)) >= n else "0" * (n - len(str(res2))) + str(res2)
        map1[i], map2[i] = res1, res2
    
    for i in range(n):
        string = ""
        for j in range(n):
            if map1[i][j] == "0" and map2[i][j] == "0":
                string += " "
            else:
                string += "#"
        answer.append(string)
    
    return answer