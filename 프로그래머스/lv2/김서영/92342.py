""" 화살 맞힌 과녁 점수 k
k점을 피치가 a, 라이언이 b발 맞힘
    - a==b==0 continue
    - a>b or a=b 피치+=k
    - a<b 라이언+=k
라이언이 피치 maximize로 이기려면(최종점수 피치 초과) n발 화살 어디에 맞혀야 하는지?

(1) 0~10 사이 숫자 11개를 더해서 n이 되게 하는 조합을 다 구해서 
    - 이거를 바이너리로 해당 과녁 점수에서 어피치한테 이기기/지기 로 가는게 낫겠다
    - 접수는 그떄그때 계산하고 라이언 점수 배열을 들고다녀야할듯
(2) 각 경우에서 def 최종점수_계산() 해오기

"""

def solution(n, info):
    max_difference = -1
    answer = []
    
    def score_difference(lion_history: list) -> int:
        ap_total, li_total = 0, 0
        for i, ap, li in enumerate(zip(info, lion_history)):
            grade = 10-i
            if ap == li == 0: continue
            if ap >= li: ap_total += grade
            else: li_total += grade
        return li_total - ap_total
    
    def backtrack(idx: int, victory: bool, lion_history: list):
        if (idx == 11 or sum(lion_history) == n) and \
        score_difference(lion_history) > max_difference: 
            if len(answer) == 0: answer = lion_history.copy()
            #TODO 낮은 점수 더 많은 경우로 업데이트
        
        # idx에서 lion 점수 setting
        g = info[idx]+1 if victory else 0
        lion_history[]
        
        # 다음 케이스 navigate
        backtrack(idx+1, True, lion_history[])
        
        
    return answer