def solution(operations):
    answer = []
    for opr in operations:
        ops = opr.split(' ')
        if ops[0] == 'I':
            answer.append(int(ops[1]))
            answer.sort()
        elif opr[0] == 'D' and len(answer) != 0:
            if int(ops[1]) == 1:
               answer.pop() 
            elif int(ops[1]) == -1:
               answer.pop(0)
    if len(answer) == 0:
        return [0,0]
    else:
        return [answer[-1], answer[0]]