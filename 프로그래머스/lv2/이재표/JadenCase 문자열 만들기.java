import java.util.*;
class Solution {
    public String solution(String s) {
        char[] sen = s.toLowerCase().toCharArray();
        
        for (int i = 0; i < sen.length; i++) {
            if (i == 0 && sen[i] >= 'a' && sen[i] <= 'z') {
                sen[i] = Character.toUpperCase(sen[i]);
            }
            else if (i > 0 && sen[i-1] == ' ' && sen[i] >= 'a' && sen[i] <= 'z') {
                sen[i] = Character.toUpperCase(sen[i]);
            }
        }
        
        return new String(sen);
    }
}
