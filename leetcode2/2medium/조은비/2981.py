class Solution:
    def maximumLength(self, s: str) -> int:
        # 가장 긴 special sub return, 세번이하 -1
        dic = {}
        result = -1
        n = len(s)
    
        # 글자별로 세는게 맞나
        for i in range(n):
            for j in range(i+1, n+1):
                sub = s[i:j]
                dic[sub] = dic.get(sub, 0) + 1
                # 이 중 3번 이상 등장해야ㅏ.

        for key, val in dic.items():
            if val >= 3:
                result = max(result, len(key))
                print(key, val, result)

        if result == 0:
            return -1
                
        return result