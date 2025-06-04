package 이재훈;

/*
1. 아이디어 :
- c 의 값이 s 에서 발견된 숫자만큼 카운트  == m
- m * (m+1)/2 로 정답 반환

2. 시간복잡도 :
O( n  )
3. 자료구조/알고리즘 :
- / 수학 연산
 */

public class Q3084 {

    class Solution {
        public long countSubstrings(String s, char c) {
            long m = 0;
            for(int i = 0; i<s.length(); i++) {
                if(s.charAt(i) == c) m++;
            }

            return m * (m+1)/2;
        }
    }
}