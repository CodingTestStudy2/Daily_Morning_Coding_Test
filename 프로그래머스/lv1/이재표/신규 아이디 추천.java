import java.util.*;
class Solution {
     public String solution(String new_id) {
        String answer = "";
        
        new_id = new_id.toLowerCase();
        
        new_id = removeSpecial(new_id);
        
        while(new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }
        
        if(new_id.length() > 0 && new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        }
        
        if(new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        
        if(new_id.length() == 0) {
            new_id = "a";
        }
        
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if(new_id.charAt(new_id.length() - 1) == '.') {
                new_id = new_id.substring(0, 14);
            }
        }
        
        while(new_id.length() <= 2) {
            new_id += new_id.charAt(new_id.length() - 1);
        }
        
        answer = new_id;
        return answer;
    }

    public String removeSpecial(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
