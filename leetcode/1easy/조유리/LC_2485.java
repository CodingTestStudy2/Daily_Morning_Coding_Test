public class LC_2485 {
    class Solution {
        public int pivotInteger(int n) {
            int totalSum  = (n+1)*(n/2);
            if(n % 2 == 1) totalSum += (n/2 + 1);
    
            int sum = 0;
            for(int i=1; i<=n; i++){
                sum += i;
                if(sum == totalSum-sum+i) return i;
            }
            return -1;
        }
    }
}
