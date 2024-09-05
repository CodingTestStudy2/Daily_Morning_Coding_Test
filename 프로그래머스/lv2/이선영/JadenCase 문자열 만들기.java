import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        s = s.toLowerCase();
        char first = s.charAt(0);
        if(first>='a' && first<='z'){
            first = (char)(first-32);
        }
        
        sb.append(first);
        for(int i=1; i<s.length(); i++){
            char letter = s.charAt(i);
            if(s.charAt(i-1) == ' ' && letter>='a' && letter<='z'){
                sb.append((char)(letter-32));
            }else{
                sb.append(letter);
            }
        }
        
        answer = sb.toString();
        return answer;
    }
}
