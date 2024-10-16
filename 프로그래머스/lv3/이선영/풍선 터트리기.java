import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int n = a.length;
    
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        int[] rightMin = new int[n];
        int[] leftMin = new int[n];
        rightMin[n-1] = a[n-1];
        leftMin[0] = a[0];
        
        
        for(int i=1; i<=n-2; i++){
            leftMin[i] = Math.min(leftMin[i-1], a[i]);
        }
        
        for(int i=n-2; i>=1; i--){
            rightMin[i] = Math.min(rightMin[i+1], a[i]);
        }
        
        for(int i=0; i<n; i++){
            if(a[i]<=leftMin[i] || a[i]<=rightMin[i]) answer++;
        }
        
        return answer;
    }
}
