def solution(phone_book):
    # n -> 1,000,000 -> O(n^2) : X
    phone_book.sort()
    answer = True
    for i in range(len(phone_book)-1):
        if phone_book[i+1].startswith(phone_book[i]):
        # if phone_book[i+1][:len(phone_book[i])] == phone_book[i]:
            answer = False
            break
    return answer
