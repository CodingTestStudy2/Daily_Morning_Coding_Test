def solution(n, m, section):
    count = 0
    i = 0

    while i < len(section):
        count += 1
        current = section[i]

        while i < len(section) and section[i] < current + m:
            i += 1

    return count