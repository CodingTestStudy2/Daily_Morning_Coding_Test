import java.util.*;
class Solution {
    static int N = 0, max = -1;
    static int[] res = new int[11];
    static int[] answer;
    
    public int[] solution(int n, int[] info) {
        
        dfs(n, 0, info);
        if(max == -1){
            answer = new int[1];
            answer[0] = -1;
        }
        return answer;
    }
    
    
    public void dfs(int n, int depth, int[] info){
        if(depth == n){
            int diff = score(info);
            if(diff >= max){
                max = diff;
                answer = res.clone();
            }
            return;
        }
        
        for(int i=0; i<info.length && res[i] <= info[i];i++){
            res[i] +=1;
            dfs(n, depth+1, info);
            res[i] -=1;
        }
        
    }
    
    //점수차 구하기
    public static int score(int[] info) {
    	int apeach=0, lion=0;
    	for(int i=0; i<res.length; i++) {
    		if(info[i]==0 && res[i]==0) continue;//i원소에 둘다 0개 맞췄을땐 무시.
    		if(info[i]>=res[i]) apeach += (10-i);
    		else lion += (10-i);
    	}
    	
    	int diff = lion - apeach;
    	if(diff<=0) return -1;
    	return diff;
    }
}
