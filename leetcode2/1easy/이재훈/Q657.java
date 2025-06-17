package Leetcode.이재훈;

/*
1. 아이디어 :
 - r != l, u != d 틀리면 false 아니면 true 를 반환함.
2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- /
 */

import java.util.Arrays;

public class Q657 {
    class Solution {
        public boolean judgeCircle(String moves) {

            int numOfR = 0;
            int numOfU = 0;
            int numOfL = 0;
            int numOfD = 0;

            for(char c : moves.toCharArray()) {
                if(c == 'R') {
                    numOfR++;
                } else if(c== 'U') {
                    numOfU++;
                } else if(c == 'L') {
                    numOfL++;
                } else {
                    numOfD++;
                }
            }

            if(numOfR != numOfL) return false;
            if(numOfU != numOfD) return false;
            return true;
        }
    }
}