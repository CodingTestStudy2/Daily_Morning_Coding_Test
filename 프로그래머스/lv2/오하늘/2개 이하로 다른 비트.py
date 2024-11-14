def solution(numbers):
    answer = []
    
    for number in numbers:
        numbeat = ''
        i = number
        
        # 이진법
        while i >= 1:
            if i % 2 == 0:
                numbeat = '0' + numbeat
            else:
                numbeat = '1' + numbeat
            i //= 2
        
        # 큰 수 찾기
        # 111의 경우, 무조건 수 하나를 더 생성해야 함.
        if '0' not in numbeat:
            numbeat = '1' + '0' + numbeat[1:]
            
        # 101의 경우 그 다음 숫자를 1만들고 0 만들면 됨.
        else:
            numbeat = list(numbeat)
            for j in range(len(numbeat)-1,-1,-1):
                if numbeat[j] == '0': # 오른쪽에서 가장 가까운 0을 1로 변경
                    numbeat[j] = '1'
                    # 그다음 1을 0으로 변경
                if j+1 < len(numbeat) and numbeat[j+1]=='1':
                    numbeat[j+1] = '0'
                break
            numbeat = ''.join(numbeat)
        
        next_number = int(numbeat, 2)
        answer.append(next_number)
    
    return answer