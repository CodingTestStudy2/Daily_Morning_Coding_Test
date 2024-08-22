import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);
        
        int[] xarr = new int[10];
        int[] yarr = new int[10];
    
        for(int i=0; i<X.length(); i++){
            char x = X.charAt(i);
            xarr[x-'0']++;
        }
        
        for(int i=0; i<Y.length(); i++){
            char y = Y.charAt(i);
            yarr[y-'0']++;
        }
        
        for(int i=0; i<10; i++){
            int cnt = Math.min(xarr[i], yarr[i]);
            if(cnt>0){
                while(cnt != 0){
                    pq.offer(i);
                    cnt--;
                }
            }
        }

        
        StringBuilder sb = new StringBuilder();
        int len = pq.size();
        for(int i=0; i<len; i++){
            sb.append(pq.poll());
        }
        
        if(sb.toString().length() == 0){
            return "-1";
        }
        
        else if(sb.toString().startsWith("0")){
            return "0";
        }
        
        String answer = sb.toString();
        return answer;
    }
}
