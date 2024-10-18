import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]>queue=new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            queue.add(new int[]{priorities[i],i});
        }
        while(!queue.isEmpty()){
            int[] current=queue.poll();
            boolean isFlag=false;
            int cnt=0;
            for(int[]q:queue){
                cnt++;
                if(q[0]>current[0]){
                    isFlag=true;
                }
            }
            if(isFlag){
                queue.offer(current);
            }else{
                if(current[1]==location){
                    return priorities.length-cnt;
                }
            }
        }
        return answer;
    }
}
