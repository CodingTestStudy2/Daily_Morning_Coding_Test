package 이재훈;

/*
1. 아이디어 :
- 헬퍼 펑션으로 각 query랑 패턴을 비교해서 맞으면 true 틀리면 false 를 반환하게 함

2. 시간복잡도 :
O( n * m )
3. 자료구조/알고리즘 :
- / 완전 탐색
 */

public class Q1023 {
    class Solution {
        public List<Boolean> camelMatch(String[] queries, String pattern) {
            List<Boolean> res = new ArrayList<>();

            for(String query : queries) {
                res.add(isMatched(query, pattern));
            }

            return res;
        }

        private boolean isMatched(String query, String pattern) {
            int pos = 0;

            for(int i = 0; i<query.length(); i++) {
                char c = query.charAt(i);

                if (pos < pattern.length()) {
                    if (c == pattern.charAt(pos)) {
                        pos++;
                        continue;
                    }
                }

                if (Character.isUpperCase(c)) {
                    return false;
                }
            }

            return pos == pattern.length();
        }
    }
}