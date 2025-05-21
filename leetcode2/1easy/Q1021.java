package Leetcode;

/*
1. 아이디어 :

- count로 감싸고있는 ()를 제외한 나머지를 sb 에 저장 후 반환

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- / 완전탐색
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1021 {
    class Solution {
        public String removeOuterParentheses(String s) {

            StringBuilder sb = new StringBuilder();

            int count = 0;

            for(char c : s.toCharArray()) {
                if(c == '(') {
                    if(count > 0) sb.append(c);
                    count++;
                } else {
                    count--;
                    if(count>0) sb.append(c);
                }
            }

            return sb.toString();
        }
    }
}