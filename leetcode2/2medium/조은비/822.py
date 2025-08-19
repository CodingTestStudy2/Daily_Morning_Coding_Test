class Solution:
    def flipgame(self, fronts: List[int], backs: List[int]) -> int:
        card = None
        # 보여지는 여부
        # 조건: 한 카드의 뒷면에 잇고 어떤 카드의 앞면에도 보이지 않을 것
        # good 이 되는 카드가 없으면 0 리턴

        # 앞뒤가 같으면 뒤집어도 그대로 - 요건 패스
        n = len(fronts)
        invalid = {fronts[i] for i in range(n) if fronts[i] == backs[i] }
        # print(invalid)

        # 앞면에서 최소 찾기
        for c in fronts:
            if c not in invalid:
                if card is None or c < card:
                    card = c

        # 뒷면에서 최소 찾기
        for c in backs:
            if c not in invalid:
                if card is None or c < card:
                    card = c

        if card is None:
            return 0
            
        return card