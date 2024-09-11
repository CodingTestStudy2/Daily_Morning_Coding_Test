import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(s/n==0){
            return new int[]{-1};
        }else{
            int a=s/n;
            int b=s%n;
            for(int i=0;i<n;i++){
                answer[i]=a; 
            }
            for(int i=0;i<b;i++){
                answer[n-i-1]++;
            }
        }
        return answer;
    }
}
