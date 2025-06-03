package Leetcode.이재훈;

/*
1. 아이디어 :

 - 1을 카운트를 하고 맨 마지막 1을 제외한 나머지를 맨 앞에서 만들어서 반환

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- /
 */

public class Q2864 {
    class Solution {
        public String maximumOddBinaryNumber(String s) {

            int n = s.length();
            int count = -1;
            for(int i = 0; i< n; i++) {
                if(s.charAt(i) == '1') count++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<n-1;i++) {
                if(count > 0) {
                    sb.append("1");
                    count--;
                } else {
                    sb.append("0");
                }
            }
            sb.append("1");

            return sb.toString();
        }
    }
}