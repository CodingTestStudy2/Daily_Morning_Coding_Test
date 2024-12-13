# 최대공약수 풀이 참고
import math

def solution(w,h):
    n = math.gcd(w,h) #최대 공약수 구하기
    exp = w+h-n # 대각선이 지나는 정사각형
    total = w*h
    return total - exp # 전체 - 정사각형