'''
1. 서로 선물을 주고 받았을 경우
2. 주고 받은 기록이 없거나, 주고 받은 수가 같음
3. 선물 지수가 같음
'''

def solution(friends, gifts):
    answer = 0
    n = len(friends)
    record = list([0] * n for _ in range(n))
    gift_jisoo = list([0] * 2 for _ in range(n))
    next_month_gift = [0] * n
    
    for gift in gifts:
        people = gift.split(" ")
        a = friends.index(people[0])
        b = friends.index(people[1])
        record[a][b] += 1
        gift_jisoo[a][0] += 1
        gift_jisoo[b][1] += 1
    #print(record, gift_jisoo)
    
    for i in range(n): # 준 사람
        for j in range(i+1, n): # 받은 사람
            if record[i][j] < record[j][i]:
                next_month_gift[j] += 1
            elif record[i][j] > record[j][i]:
                next_month_gift[i] += 1
            elif record[i][j] == record[j][i]:
                a_jisoo = gift_jisoo[i][0] - gift_jisoo[i][1]
                b_jisoo = gift_jisoo[j][0] - gift_jisoo[j][1]
                if a_jisoo > b_jisoo:
                    next_month_gift[i] += 1
                elif a_jisoo < b_jisoo:
                    next_month_gift[j] += 1
    
    answer = max(next_month_gift)
    
    return answer