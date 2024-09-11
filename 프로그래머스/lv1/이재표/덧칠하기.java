import java.util.*;
class Solution {
    public int solution(int n, int m, int[] sections) {
        int answer = 0;
        boolean[]arr=new boolean[n+1];
        Arrays.fill(arr,true);
        for(int section:sections){
            arr[section]=false;
        }
        for(int i=0;i<=n;){
            if(arr[i]==false){
                for(int j=0;j<m;j++){
                    if(i+j<n){
                        arr[i+j]=true;
                    }
                }
                answer++;
                i=i+m;
                continue;
            }
            i++;
        }
        return answer;
    }
}
