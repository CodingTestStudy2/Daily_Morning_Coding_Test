import java.util.*;
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = {};
        answer=new long[numbers.length];
        int idx=0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]%2==0){
                answer[idx++]=numbers[i]+1;
                continue;
            }
            String target = Long.toBinaryString(numbers[i]);
            int index01=target.lastIndexOf("0");
            if(index01==-1){
                String tmp="10"+target.substring(1,target.length());
                answer[idx++]=Long.parseLong(tmp,2);
            }else{
                String tmp=target.substring(0,index01)+"10"+target.substring(index01+2,target.length());
                answer[idx++]=Long.parseLong(tmp,2);
            }
        }
        return answer;
    }
}
