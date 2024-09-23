import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int n = 0;
        for (int i = 0; i <= 1000; i++) {
            n += i;
        }
        
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int answer = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    int sum=nums[i]+nums[j]+nums[k];
                    if(isPrime[sum]){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
