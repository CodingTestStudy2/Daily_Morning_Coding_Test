/**
공백 기준
*/
import java.util.*;

class Solution {
    public String solution(String s) {
        String[] s_arr = s.split("");
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        
        for (var i=0; i<s_arr.length; i++) {
            if (s_arr[i].equals(" ")) {
                sb.append(" ");
                idx = 0;
            } else if (idx % 2 == 0) {
                sb.append(s_arr[i].toUpperCase());
                idx++;
            } else {
                sb.append(s_arr[i].toLowerCase());
                idx++;
            }
        }
        
        return sb.toString();
    }
}