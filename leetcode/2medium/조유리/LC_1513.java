public class LC_1513 {
    class Solution {
        public int numSub(String s) {
            int MOD = (int)(1e9 + 7);
            s += "0";
            int len = s.length();
            int[] dp = new int[len+1];
            long ans = 0;
            for(int i=0; i<len; i++){
                int c = s.charAt(i);
                if(c == '1'){
                    dp[i+1] = dp[i]+1;
                }
                else{
                    dp[i+1] = 0;
                    ans = (ans + cntSubstring(dp[i])) % MOD;
                }
            }
            return (int)ans;
        }
    
        // 1이 n개인 substring의 갯수를 반환 (1~n 의 합)
        public long cntSubstring(int n){
            return ((long)n * (n + 1)) / 2;
        }
    }   
}
