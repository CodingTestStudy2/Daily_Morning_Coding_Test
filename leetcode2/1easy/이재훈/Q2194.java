package Leetcode.이재훈;

/*
1. 아이디어 :

 - 스트링에서 c1 ~ r2까지의 모든 숫자를 브르투 포스 형식으로 처리

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- / 완전탐색
 */

import java.util.ArrayList;
import java.util.List;

public class Q2194 {
    class Solution {
        public List<String> cellsInRange(String s) {

            char startAlpha = s.charAt(0);
            int startNum = s.charAt(1) - '0';
            char endAlpha = s.charAt(3);
            int endNum = s.charAt(4) - '0';

            List<String> res = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            for(char i = startAlpha; i <=endAlpha; i++) {
                for(int j = startNum; j <= endNum; j++) {
                    sb.setLength(0);
                    sb.append(i).append(j);
                    res.add(sb.toString());
                }
            }
            return res;
        }
    }
}