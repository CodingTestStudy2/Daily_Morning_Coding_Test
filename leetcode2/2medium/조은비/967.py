class Solution:
    def numsSameConsecDiff(self, n: int, k: int) -> List[int]:
        result = []
        
        # 길이 - n, 이전자리 +-k인 숫자 추가 가능
        # 다음자리 숫자 경우
        next = []
        last = n
        if last + k <= 9:
            next.append(last + k)
        if last - k >= 0:
            next.append(last - k)

        print(next)
        
        # 그럼 가능 숫자 골라내고 각 자리별 경우의 수 전체 구하기


        # 길이가 n 이 되면 결과 리스트 추가
        
        # 0~9 숫자 중 조합해서... 첫자리는 1~9
        # (10**자릿수) * 숫자

        
        return result