import java.util.*;
class Solution {
    int n;
    int answer = 0;
    public int solution(int[] numbers) {
        n=numbers.length;
        boolean[] visit=new boolean[n];
        dfs(numbers,0,0,0);
        return answer;
    }
    public void dfs(int[]numbers,int start,int cnt,int sum){
        if(cnt==3){
            if(sum==0){
                answer++;                
            }
            return;
        }
        for(int i=start;i<n;i++){
            dfs(numbers,i+1,cnt+1,sum+numbers[i]);
        }
    }
}
