'''
1. 아이디어 :
첫번째 행의 마지막
첫번째 행의 마지막 - 1 -> 두번째 행의 마지막
첫번째 행의 마지막 - 2 -> 두번째 행의 마지막 - 1 -> 세번 째 행의 마지막
첫번째 행의 마지막 - 3 -> 두번째 행의 마지막 - 2 -> 세번째 행의 마지막 -1
                      두번째 행의 마지막 - 3 -> 세번째 행의 마지막 -2
                                         -> 세번째 행의 마지막 -3
[0][-1]
[0][-2] [1][-1]
[0][-3] [1][-2] [2][-1]
[0][-4] [1][-3] [2][-2]
        [1][-4] [2][-3]
                [2][-4]

2. 시간복잡도 :
o(n ^ 2 log n)

3. 자료구조/알고리즘 :
                
'''

class Solution:
    def diagonalSort(self, mat: List[List[int]]) -> List[List[int]]:
        x_len = len(mat[0])
        y_len = len(mat)

        dic = {}
        lst = []
        j = -1
        for i in range(y_len):
            dic[i] = j
            j += 1
        
        while True:
            tmp = []
            for y in range(y_len):
                if -x_len <= dic[y] <= -1:
                    tmp.append((dic[y],y))
            
            for k in dic.keys():
                dic[k] -= 1
            lst.append(tmp)

            if all([not(-x_len <= i <= -1) for i in dic.values()]):
                break
        
        print(lst)

        for tmp in lst:
            vals = sorted([mat[y][x] for x,y in tmp])
            
            while tmp:
                x,y = tmp.pop()
                v = vals.pop()

                mat[y][x] = v
        
        return mat
            