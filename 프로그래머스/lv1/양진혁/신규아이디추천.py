def solution(new_id):
    # 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    new_id = new_id.lower()
    # 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    temp = ''
    for i in new_id:
        if i.isalpha() or i.isdigit() or i == "-" or i == "_" or i == ".":
            temp += i
    new_id = temp
    # 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    while ".." in new_id:
        new_id = new_id.replace("..", ".")

    # 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    def remove_dot(new_id):
        while new_id.startswith(".") or new_id.endswith("."):
            if new_id.startswith("."):
                new_id = new_id[1:]
            if new_id.endswith("."):
                new_id = new_id[:-1]
        return new_id

    new_id = remove_dot(new_id)

    # 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    if new_id == "":
        new_id = "aaa"
    # 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
    if len(new_id) >= 16:
        new_id = new_id[:15]
    #      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    new_id = remove_dot(new_id)
    # 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
    if len(new_id) < 3:
        new_id = new_id + new_id[-1] * (3 - len(new_id))

    return new_id