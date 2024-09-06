def solution(s):
    answer = []

    time = 0
    zero_cnt = 0

    while s != "1":
        time += 1
        zero_cnt += s.count("0")

        s = s.replace("0", "")
        s = bin(len(s))[2:]

    answer.append(time)
    answer.append(zero_cnt)

    return answer