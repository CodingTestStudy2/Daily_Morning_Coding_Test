import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        Map<String,Integer>type=new HashMap<>();
        for(int i=0;i<gems.length;i++){
            type.put(gems[i],type.getOrDefault(gems[i],0)+1);
        }        
        int end=gems.length-1;
        int start=0;
        for(int i=end;i>=0;i--){
            int gemCnt=type.get(gems[i]);
            if(gemCnt-1==0){
                end=i;
                break;
            }
            type.put(gems[i],gemCnt-1);
        }
        for(int i=0;i<end;i++){
            int gemCnt=type.get(gems[i]);
            if(gemCnt-1==0){
                start=i;
                break;
            }
            type.put(gems[i],gemCnt-1);
        }
        
        int[]answer={start+1,end+1};
        
        while(end+1<gems.length){
            end++;
            type.put(gems[end],type.getOrDefault(gems[end],0)+1);
            for(int i=start;i<=end;i++){
                int gemCnt=type.get(gems[i]);
                if(gemCnt-1==0){
                    start=i;
                    break;
                }
                type.put(gems[i],gemCnt-1);
            }
            if(end-start<answer[1]-answer[0]){
                answer[0]=start+1;
                answer[1]=end+1;
            }
        }
        return answer;
    }
}
