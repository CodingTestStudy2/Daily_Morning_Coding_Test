package Leetcode;

/*
1. 아이디어 :

 - t 길이만큼 돌면서 s를 구성요소를 다 찾으면 true, 아니면 false를 리턴

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- /
 */

public class Q392 {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            int idx = 0;
            for(int i = 0; i < t.length(); i++) {
                if(s.length() == idx) return true;
                if(s.charAt(idx) == t.charAt(i)) {
                    idx++;
                }
            }

            return idx == s.length();
        }
    }
}