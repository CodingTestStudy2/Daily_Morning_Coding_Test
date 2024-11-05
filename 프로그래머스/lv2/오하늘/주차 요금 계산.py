import math
def solution(fees, records):
    answer = []
    
    standard, st_money, over, over_money = fees # 기본 요금, 초과 요금
    
    info = {}
    for re in records:
        time, number, i_o = re.split()
        if number not in info:
            info[number] = []
        info[number].append(time)
            
    info = dict(sorted(info.items())) # 번호 작은 순
    
    # 요금 부과
    for num, times in info.items():
        total = 0
        
        # 출차 기록이 없다면 23:59로 간주
        if len(times) % 2 == 1:
            times.append("23:59")
        
        # 시간 계산
        for i in range(0, len(times), 2): # 2개 단위로
            in_time = times[i]
            out_time = times[i + 1]
            in_h, in_m = map(int, in_time.split(':'))
            out_h, out_m = map(int, out_time.split(':'))
            total += (out_h * 60 + out_m) - (in_h * 60 + in_m)
        # 비용 계산
        if total < standard:
            answer.append(st_money) # 기본 요금
        else:
            over_time = total-standard
            over_fee = math.ceil(over_time/over) * over_money
            answer.append(st_money+over_fee) # 초과요금

    
    return answer