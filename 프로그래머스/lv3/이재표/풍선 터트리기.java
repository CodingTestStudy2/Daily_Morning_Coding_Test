import java.util.*;
class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] leftMin=new int[a.length];
        int[] rightMin=new int[a.length];
        for(int i=0;i<a.length;i++){
            if(i==0){
                leftMin[i]=a[i];
                continue;
            }
            leftMin[i]=Math.min(a[i],leftMin[i-1]);
        }
        for(int i=a.length-1;i>=0;i--){
            if(i==a.length-1){
                rightMin[i]=a[i];
                continue;
            }
            rightMin[i]=Math.min(a[i],rightMin[i+1]);
        }
        answer=2;
        for(int i=1;i<a.length-1;i++){
            int cnt=0;
            if(a[i]>leftMin[i-1]){
                cnt++;
            }
            if(a[i]>rightMin[i+1]){
                cnt++;
            }
            if(cnt<=1){
                answer++;
            }
        }
        return answer;
    }
}
