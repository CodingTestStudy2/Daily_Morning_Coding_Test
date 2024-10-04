import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long start=1;
        long end = (long) times[times.length - 1] * n;
        long answer = end;
        while(start<=end){
            long total=0;
            long mid=(end+start)/2;
            for(int i=0;i<times.length;i++){
                total+=mid/times[i];
            }
            if(total>=n){
                answer=Math.min(answer,mid);
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return answer;
    }
}
