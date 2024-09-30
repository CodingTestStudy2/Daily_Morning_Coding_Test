import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        Queue<String>q1=new LinkedList<>();
        Queue<String>q2=new LinkedList<>();
        for(int i=0;i<cards1.length;i++){
            q1.offer(cards1[i]);
        }
        for(int i=0;i<cards2.length;i++){
            q2.offer(cards2[i]);
        }
        boolean[]visit=new boolean[goal.length];
        for(int i=0;i<goal.length;i++){
            if(goal[i].equals(q1.peek())){
                q1.poll();
                visit[i]=true;
                continue;
            }
            if(goal[i].equals(q2.peek())){
                q2.poll();
                visit[i]=true;
                continue;
            }
        }
        for(int i=0;i<goal.length;i++){
            if(!visit[i]){
                return "No";
            }
        }
        return "Yes";
    }
}
