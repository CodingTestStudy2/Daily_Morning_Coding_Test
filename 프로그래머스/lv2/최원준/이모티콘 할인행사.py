from itertools import combinations
def solution(users, emoticons):
    discounts = [10,20,30,40]

    combs = []

    curr = []
    def backtrack(idx, counts):
        if counts == len(emoticons):
            combs.append(curr.copy())
            return
        for i in range(4):
            curr.append(discounts[i])
            backtrack(i, counts+1)
            curr.pop()

    backtrack(0,0)
    # print(combs)

    ans = [0,0]
    for comb in combs:
        pack = 0
        sold = 0
        for user in users:
            user_discount, user_budget = user
            total_bought = sum([emoticons[i] * (100-comb[i])/100 for i in range(len(emoticons)) if comb[i] >= user_discount])
            if total_bought >= user_budget:
                pack+=1
            else:
                sold += total_bought
        # print(comb, pack,sold)
        if pack > ans[0]:
            ans = [pack, sold]
        elif pack == ans[0] and sold > ans[1]:
            ans[1] = sold

    return ans