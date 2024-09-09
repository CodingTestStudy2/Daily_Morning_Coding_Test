import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(int n) {
        for(int i=1;i<=n;i++){
            dfs(i, 0, n);    
        }
        return answer;
    }
    public void dfs(int now, int sum, int n) {
        if(sum>n){
            return;
        }else if(sum==n){
            answer++;
        }
        dfs(now+1,sum+now,n);
    }
}
