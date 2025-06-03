package Leetcode.이재훈;

/*
1. 아이디어 :

 -

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- / 완전탐색
 */

public class Q3330 {
    class Solution {
        public int possibleStringCount(String word) {

            int res = word.length();

            for(int i = 1; i<word.length(); i++) {
                if(word.charAt(i-1) != word.charAt(i)) res--;
            }

            return res;

        }
    }
}