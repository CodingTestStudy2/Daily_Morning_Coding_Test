# 방법 1
class Leetcode.이재훈.Solution:
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:
        for word in dictionary:
            s = s.replace(word, "") # 딕셔너리에서 문자 삭제
        return len(s)

# 물론, 최적의 답을 못찾아서 틀림.
# 풀이 참조. dp를 사용하면 된다고 한다.

def minExtraChar(s, dictionary):
    n = len(s)
    dp = [float('inf')] * (n + 1)  # dp 배열: s[0:i]까지의 최소 남는 문자를 저장
    dp[0] = 0

    word_set = set(dictionary)  # 빠른 검색을 위한

    for i in range(1, n + 1):  # 문자열의 끝 위치를 i로 설정
        for j in range(i): # 문자열의 시작
            # s[j:i]가 딕셔너리에 있으면
            if s[j:i] in word_set:
                dp[i] = min(dp[i], dp[j])  # 추가 남는 문자 없이 이어가기
            else:
                dp[i] = min(dp[i], dp[j] + (i - j))  # s[j:i]가 매칭되지 않으면 남는 문자를 더함

    return dp[n]  # 전체 문자열의 최소 남는 문자 수 반환
