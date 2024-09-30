def match(ban, user):
    if len(ban) != len(user):
        return False
    for b, u in zip(ban, user):
        if b != '*' and b != u:
            return False
    return True

def find_matches(ban, users):
    return [user for user in users if match(ban, user)]

# curr 현재까지 선택된 사용자들의 집합 (중복 방지), result: 가능한 고유 사용자 조합을 저장하는 집합 (중복 허용 안 함)
def find_combinations(cands, idx, curr, result):
    if idx == len(cands):
        # frozenset : 변경 불가능한 집합
        result.add(frozenset(curr))
        return
    # 후보군에서 각 사용자 확인
    for user in cands[idx]:
      # 중복되지 않는 사용자 선택
        if user not in curr:
            curr.add(user)
            find_combinations(cands, idx + 1, curr, result)
            curr.remove(user)

def solution(users, bans):
    # 각 금지 ID 패턴에 맞는 사용자 후보들의 리스트 cands[0]은 첫번째 금지에 맞는 거,,
    cands = [find_matches(ban, users) for ban in bans]
    
    result = set()
    find_combinations(cands, 0, set(), result)
    
    return len(result)
