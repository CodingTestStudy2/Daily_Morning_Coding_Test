import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int idx=0;
        int n=truck_weights.length;
        Queue<Integer>bridge=new LinkedList<>();
        for(int i=0;i<bridge_length;i++){
            bridge.offer(0);
        }
        int current_weight=0;
        int time=0;
        while(n>idx){
            if(bridge.size()==bridge_length){
                current_weight-=bridge.poll();
            }
            if(current_weight+truck_weights[idx]<=weight){
                bridge.offer(truck_weights[idx]);
                current_weight+=truck_weights[idx++];
            }else{
                bridge.offer(0);
                current_weight+=0;
            }
            time++;
        }
        if(!bridge.isEmpty()){
            time+=bridge.size();  
        }
        return time;
    }
}
