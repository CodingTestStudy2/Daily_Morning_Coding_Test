def solution(babbling):
    answer = 0
    standards = ["aya", "ye", "woo", "ma"]

    for word in babbling:
        for standard in standards:
            if standard * 2 not in word:
                word = word.replace(standard, " ")

        if word.isspace():
            answer += 1

    return answer