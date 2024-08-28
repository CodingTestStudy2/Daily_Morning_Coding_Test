def solution(survey, choices):
    answer = ''
    dic = {'R': 0, 'T': 0, 'C': 0, 'F': 0, 'J': 0, 'M': 0, 'A': 0, 'N': 0}

    for i in range(len(survey)):
        no1, no2 = survey[i][0], survey[i][1]
        choice = choices[i]

        if choice < 4:
            dic[no1] += 4 - choice
        elif choice > 4:
            dic[no2] += choice - 4

    answer += 'R' if dic['R'] >= dic['T'] else 'T'
    answer += 'C' if dic['C'] >= dic['F'] else 'F'
    answer += 'J' if dic['J'] >= dic['M'] else 'M'
    answer += 'A' if dic['A'] >= dic['N'] else 'N'

    return answer