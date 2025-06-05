<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def countDaysTogether(self, arriveAlice: str, leaveAlice: str, arriveBob: str, leaveBob: str) -> int:
        def parse_date(date):
            return tuple(map(int, date.split("-")))
        a1, a2 = parse_date(arriveAlice)
        l1, l2 = parse_date(leaveAlice)
        b1, b2 = parse_date(arriveBob)
        l3, l4 = parse_date(leaveBob)

        # 늦게 도착한 날짜
        if (a1, a2) > (b1, b2):
            m, d = a1, a2  # Alice가 더 늦게 도착
        else:
            m, d = b1, b2
                
        # 빨리 떠나는 날짜
        if (l1, l2) < (l3, l4):
            m2, d2 = l1, l2  # Alice
        else:
            m2, d2 = l3, l4
        
        ans = 0
        if m == m2:  # 같은 월
            ans = d2 - d + 1
        else:  # 다른 월
            if m2 < m:  # 떠나는 날이 도착한 날보다 앞서면 만난 기간 없음
                return 0
            else:
                for k in range(m, m2 + 1):
                    if k in {1, 3, 5, 7, 8, 10, 12}:
                        ans += 31
                    elif k == 2:
                        ans += 28
                    else:
                        ans += 30
                ans -= d-1  # 시작 날짜 조정
                ans -= (31 if m2 in {1, 3, 5, 7, 8, 10, 12} else (28 if m2 == 2 else 30)) - d2
        
        return max(0, ans)
