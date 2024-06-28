import math
# 공약수면서 상대방의 숫자들의 약수가 아니다.
# 원소의 크기가 매우 크다 -> 일일이 찾을 수 없음 -> gcd함수 활용해서 최대공약수 찾고 그 최대공약수의 약수를 찾는 방식으로 해결
# 중복된 원소가 있는 경우는 return 0

def searchCommon(arr):
    num = arr[0]
    gcd = 0
    for i in arr:
        gcd = math.gcd(num,gcd)
        num = i
    # 공약수 구하기
    common = []
    for i in range(1,gcd+1):
        if gcd % i == 0 :
            common.append(i)
    return common

def checkOtherArr(common,other,checkedList):
    for i in common:
        isPossible = True
        for j in other:
            if j % i == 0:
                isPossible = False
        if isPossible :
            checkedList.append(i)
    
def solution(arrayA, arrayB):
    checkedList =[]
    a_common = searchCommon(arrayA)
    checkOtherArr(a_common,arrayB,checkedList)
    
    b_common = searchCommon(arrayB)
    checkOtherArr(b_common,arrayA,checkedList)
    
    if not checkedList:
        return 0
    return max(checkedList)