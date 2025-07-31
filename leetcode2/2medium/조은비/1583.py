
class Solution:
    def unhappyFriends(self, n: int, preferences: List[List[int]], pairs: List[List[int]]) -> int:
        partner = {}
        prefer = [[0]*n for _ in range(n)]

        for x, y in pairs:
            partner[x] = y
            partner[y] = x
    
        for i in range(n):
            j=1
            for p in preferences[i]:
                prefer[i][p] = j
                j+=1

        # print(prefer)
        # 선호 순위는 정함... 0이면 본인이고 나머지는 1~3순위로 표현
        # 이제 페어링했을때 불행도? 따지기
        unhappy = []

        for x in range(n):
            # x가 현재짝 y보다 u를 좋아함
            # u도 본인짞 v보다 x가 더 좋으면 불행한 페어가 됨...
            
            # 현재 짝 체크
            y = partner[x]
            # 선호순에서 u의 현재짝 체크과 선호 체크
            for u in preferences[x]:
                # 짝보다 더 좋아하는 사람들을 u로 둿을때 u의 짝 체크
                if u == y:
                    break
                v = partner[u]
                if prefer[u][x] < prefer[u][v]:
                    unhappy.append(x)
                    break

            # print(unhappy)

        return len(unhappy)