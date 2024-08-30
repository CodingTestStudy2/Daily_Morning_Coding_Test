import datetime
from dateutil.relativedelta import relativedelta

def solution(today, terms, privacies):
    answer = []

    today_datetime = datetime.datetime(int(today.split('.')[0]), int(today.split('.')[1]), int(today.split('.')[2]))

    terms_dict = dict()
    for term in terms:
        terms_dict[term.split()[0]] = term.split()[1]

    for i in range(len(privacies)):
        privacie = privacies[i]
        privacie_date = privacie.split()[0]
        privacie_term = privacie.split()[1]

        privacie_datetime = datetime.datetime(int(privacie_date.split('.')[0]), int(privacie_date.split('.')[1]), int(privacie_date.split('.')[2]))

        limit_datetme = privacie_datetime + relativedelta(months=int(terms_dict[privacie_term]))
        if today_datetime >= limit_datetme:
            answer.append(i + 1)

    return answer

# [1, 3]
print(solution("2022.05.19", ["A 6", "B 12", "C 3"], ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]))
# [1, 4, 5]
print(solution("2020.01.01", ["Z 3", "D 5"], ["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"]))
