# 풀이 참고
def dfs(arr, x, y, n): # 배열, 좌표, 탐색 변의 길이
    for i in range(x,x+n):
        for j in range(y,y+n):
            if (arr[i][j] != arr[x][y]) : # 값이 같은 경우 분할 x
                n //= 2
                dfs(arr,x,y,n) # 좌상단
                dfs(arr,x+n,y,n) # 우상단
                dfs(arr,x,y+n,n) # 좌하단
                dfs(arr,x+n,y+n,n) # 우하단
                return
    answer[arr[x][y]] += 1

def solution(arr):
    global answer
    answer = [0,0]
    dfs(arr,0,0,len(arr))
    
    return answer