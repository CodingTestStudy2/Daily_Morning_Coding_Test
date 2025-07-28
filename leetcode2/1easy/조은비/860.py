class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        # 현금 없이 레몬에이드 팔기
        f_d = 0
        t_d = 0

        for bill in bills:
            if bill == 5:
                f_d += 1
            elif bill == 10:
                if f_d == 0:
                    return False
                f_d -= 1
                t_d += 1
            else:
                if t_d > 0 and f_d > 0:
                    t_d -= 1
                    f_d -= 1
                elif f_d >= 3:
                    f_d -= 3
                # 20$
                else:
                    return False
        return True
            
            # print(f_d, t_d, bill)

        