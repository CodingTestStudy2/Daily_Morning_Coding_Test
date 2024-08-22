import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        String tmp = s.toString();
        
        for(int i=1; i<=s.length()/2; i++){
            StringBuilder sb = new StringBuilder();
            String base = s.substring(0,i);
            int cnt = 1;
           
            for(int j=i; j<s.length(); j+=i){
                int lastIdx = Math.min(i+j, s.length());
                String compare = s.substring(j, lastIdx);
                if(base.equals(compare)){
                    cnt++;
                }else{
                    if(cnt > 1){
                        sb.append(cnt);
                    }
                    sb.append(base);
                    base = compare;
                    cnt=1;
                }
            }
            if(cnt > 1){
                sb.append(cnt);
            }
            sb.append(base);
            answer = Math.min(answer, sb.toString().length());
            // tmp = answer == sb.toString().length() ? sb.toString() : tmp;
            // System.out.println(tmp +" " +answer );
        }
        return answer;
    }
}
