import java.util.*;
class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
   
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            char next = (char)(c+n);
            
            if((int)c >=97 && (int)c<=122){    
                if((int)next > 122){
                    next = (char)((next%123)+97);
                   
                }
            }else if((int) c >=65 && (int) c<=90){
                if((int)next > 90){
                    next = (char)((next%91)+65);
                }
            }else if(c==' '){
                next = c;
            }
            sb.append(next);
        }
        
        return sb.toString();
    }
}
