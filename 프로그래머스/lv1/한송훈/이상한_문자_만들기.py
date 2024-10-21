def solution(s):
    all_words = s.split(" ")
    answer_list = []
    for i in all_words:
        word = ""
        for idx, j in enumerate(i):
            if idx%2==0:
                word += j.upper()
            else:
                word += j.lower()
        answer_list.append(word)
    answer = " ".join(answer_list)
    return answer