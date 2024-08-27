# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''

def solution(n, info):
    apeach = sum([10-i for i in range(11) if info[i] >= 1])
    max_diff = [0]
    best_path = [-1] * 11

    def backtrack(arrows, idx, apeach, ryan, cpath):
        if idx == 11:
            cpath[10] += arrows  # 남은 화살을 0점에 배치
            diff = ryan - apeach
            if diff > max_diff[0]:
                max_diff[0] = diff
                best_path[:] = cpath[:]
            elif diff == max_diff[0]:
                for i in range(10, -1, -1):  # 낮은 점수부터 비교
                    if cpath[i] > best_path[i]:
                        best_path[:] = cpath[:]
                        break
                    elif cpath[i] < best_path[i]:
                        break
            cpath[10] -= arrows  # 원상복구
            return

        req_arrows = info[idx] + 1
        score = 10-idx
        if arrows >= req_arrows:
            cpath[idx] += info[idx]+1
            if info[idx] >= 1:
                backtrack(arrows-req_arrows, idx+1, apeach-score, ryan + score, cpath)
            else:
                backtrack(arrows-req_arrows, idx+1, apeach, ryan + score, cpath)
            cpath[idx] -= info[idx]+1

        backtrack(arrows, idx+1, apeach, ryan, cpath)

    backtrack(n, 0, apeach, 0, [0] * 11)
    return best_path if max_diff[0] > 0 else [-1]











    scores = []
    apeach = sum([10-i for i in range(11) if info[i] >= 1])

    for i, count in enumerate(info):
        if count >= 1:
            scores.append(((10-i)*2/(count+1), count+1, i))
        else:
            scores.append(((10-i)/(count+1), count+1, i))

    ans = [0] * 11
    total = 0
    scores.sort(key=lambda x:(-x[0], x[1]), reverse=True)
    for i in range(n):
        score, arrows, idx = scores.pop()
        if n - arrows >= 0:
            total += score
            n -= arrows
            ans[idx] += arrows
            if info[idx] >= 1:
                apeach-=score
    print(scores)
    print(apeach)
    print(total)
    print(ans)
    if total <= apeach:
        return [-1]
    if n:
        ans[-1] += n
    return ans



    answer = []
    return answer
