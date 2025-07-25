class Solution:
    def assignElements(self, groups: List[int], elements: List[int]) -> List[int]:
        # 가능한 요소가 여러개면 가장 작은 인덱스 선택
        # 없으면 -1 할당
        # 한번에 여러개 할당 가능

        result = [-1] * len(groups)
        
        # index j를 인덱스 i에 assigned 조건 - group[i] % elements[j]
        j = 0
        for group in groups:
            i = 0
            # 아 근데 4, 2 처럼 약수가 보장된건 점검 안해봐도 될 것 같기도,,
            for ele in elements:
                if group % ele == 0:
                    result[j] = i
                    break

                i+=1
            j+=1

        return result
