class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        # sting s가 길이가 k인 모든 binary string 조합을 포함하는지?
        # 아 k길이에서 생성할 수 있는 서브 스트링 수 다 나왔는지 체크??
        total = 2**k

        # sub string set 만들고 확인
        # 1칸씩 k만큼 윈도우 잡으면서 이동
        sub_str = set()
        # 001101[10] - 7개 8-2+1
        # 0110 - 4개
        # 01[10] - 3개 4-2+1 
        for i in range(len(s) - k + 1):
            sub_str.add(s[i:i+k])

        # substring 다 있는지 확인
            if len(sub_str) == total:
                return True
        # print(len(sub_str), total, sub_str)
        # return len(sub_str) == total

        return False
            