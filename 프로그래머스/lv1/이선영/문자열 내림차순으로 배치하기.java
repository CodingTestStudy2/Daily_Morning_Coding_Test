//https://school.programmers.co.kr/learn/courses/30/lessons/12917
import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Character> pq = new PriorityQueue<>((o1,o2)-> o2-o1);
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            pq.offer(c);
        }
        
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        
        return sb.toString();
    }
}
