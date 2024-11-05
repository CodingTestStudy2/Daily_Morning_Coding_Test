'''
기본 시간, 기본 요금
주어진대로 구현
'''
import math
from collections import defaultdict

def solution(fees, records):
    answer = []
    
    def getMinutes(x):
        times = x.split(":")
        return int(times[0]) * 60 + int(times[1])
    
    cars = dict()
    car_records = defaultdict(int)
    
    for record in records:
        record_list = record.split(" ")
        if record_list[2] == "IN":
            mm = getMinutes(record_list[0])
            cars[record_list[1]] = mm
        else:
            mm = getMinutes(record_list[0])
            minus_mm = mm - cars[record_list[1]]
            del cars[record_list[1]]
            car_records[record_list[1]] += minus_mm
    
    for car in cars.keys():
        car_records[car] += getMinutes("23:59") - cars[car]
    
    result = sorted(car_records.items(), key=lambda x:x[0])
    
    for item in result:
        num, minutes = item
        if minutes > fees[0]:
            answer.append(fees[1] + math.ceil((minutes - fees[0]) / fees[2]) * fees[3])
        elif minutes <= fees[0]:
            answer.append(fees[1])
    
    return answer