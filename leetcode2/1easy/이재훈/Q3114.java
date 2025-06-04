package Leetcode.이재훈;

/*
1. 아이디어 :

 - 완전탐색으로 처리

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- / 완전탐색
 */

public class Q3114 {
    class Solution {
        public String findLatestTime(String s) {

            StringBuilder sb = new StringBuilder();
            int idx = s.indexOf(":");
            String mm = s.substring(0, idx);
            String hh = s.substring(idx+1);


            if(mm.charAt(0) == '?' && mm.charAt(1) == '?') {
                sb.append("11");
            } else if(mm.charAt(0) != '?' && mm.charAt(1) != '?') {
                sb.append(mm.charAt(0)).append(mm.charAt(1));
            } else {
                if(mm.charAt(0) == '?') {
                    int secondH = mm.charAt(1) - '0';
                    if(secondH > 1) {
                        sb.append("0").append(secondH);
                    } else {
                        sb.append("1").append(secondH);
                    }
                } else {
                    int firstH = mm.charAt(0) - '0';
                    if(firstH == 0) {
                        sb.append(firstH).append("9");
                    } else {
                        sb.append(firstH).append("1");
                    }
                }
            }

            sb.append(":");
            if(hh.charAt(0) != '?' && hh.charAt(1) != '?') {
                sb.append(hh.charAt(0)).append(hh.charAt(1));
            } else if(hh.charAt(0) == '?' && hh.charAt(1) == '?') {
                sb.append("5").append("9");
            } else {
                if(hh.charAt(0) == '?') {
                    sb.append("5").append(hh.charAt(1));
                } else {

                    sb.append(hh.charAt(0)).append("9");
                }

            }

            return sb.toString();
        }
    }
}