import java.util.*;

class Solution {
    public String solution(String s){
        String answer = "";
        char[] c = s.toCharArray();
        boolean flag = true;

        c[0] = Character.toUpperCase(c[0]);

        for (int i = 1; i < c.length; i++) {
            c[i] = Character.toLowerCase(c[i]);
        }

        for (int j = 1; j < c.length; j++) {
            if(c[j] == ' ') {
                flag = false;
                continue;
            }

            if(!flag) {
                c[j] = Character.toUpperCase(c[j]);
                flag = true;
            }
        }

        answer = String.valueOf(c);
        return answer;
    }
}
