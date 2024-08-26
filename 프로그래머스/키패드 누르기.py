# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


def solution(numbers, hand):
    n = len(numbers)
    left_n = set([1,4,7])
    right_n = set([3,6,9])

    cords = {
        1:(0,0), 2:(0,1), 3:(0,2), 4:(1,0), 5:(1,1), 6:(1,2), 7:(2,0), 8:(2,1), 9:(2,2), 0:(3,1)
    }

    def get_distance(start, end):
        x1, y1 = start
        x2, y2 = end
        return abs(x1-x2) + abs(y1-y2)

    left = (3,0)
    right = (3,2)
    ans = ""
    for target in numbers:
        target_cord = cords[target]
        if target in left_n:
            ans += "L"
            left = target_cord
        elif target in right_n:
            ans += "R"
            right = target_cord
        else:
            left_d, right_d = get_distance(left, target_cord), get_distance(right, target_cord)
            if left_d < right_d:
                ans += "L"
                left = target_cord
            elif left_d > right_d:
                ans += "R"
                right = target_cord
            else:
                if hand == "left":
                    ans += "L"
                    left = target_cord
                else:
                    ans += "R"
                    right = target_cord
    return ans