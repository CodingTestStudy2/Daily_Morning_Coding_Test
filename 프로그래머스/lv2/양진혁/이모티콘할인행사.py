


def solution(users, emoticons):
    membership = 0
    profit = 0

    data = [10, 20, 30, 40]
    discount = []

    def dfs(depth, temp):
        if depth == len(temp):
            discount.append(temp[:])
            return
        for d in data:
            temp[depth] += d
            dfs(depth + 1, temp)
            temp[depth] -= d

    dfs(0, [0] * len(emoticons))

    for d in range(len(discount)):
        join = 0
        user_fee = [0] * len(users)

        # 할인율 확인, 개인 금액 갱신
        for e in range(len(emoticons)):
            for u in range(len(users)):
                if users[u][0] <= discount[d][e]:
                    user_fee[u] += int(emoticons[e] / 100 * (100 - discount[d][e]))

        # 멤버쉽 갱신
        for u in range(len(users)):
            if users[u][1] <= user_fee[u]:
                join += 1
                user_fee[u] = 0

        if membership < join:
            membership = join
            profit = sum(user_fee)
        elif membership == join:
            profit = max(profit, sum(user_fee))

    return [membership, profit]

print("reuslt = ", [1, 5400])
print(solution([[40, 10000], [25, 10000]], [7000, 9000]))
print("reuslt = ", [4, 13860])
print(solution([[40, 2900], [23, 10000], [11, 5200], [5, 5900], [40, 3100], [27, 9200], [32, 6900]], [1300, 1500, 1600, 4900]))