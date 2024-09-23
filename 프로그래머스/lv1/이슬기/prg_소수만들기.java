/**
* 에라토스테네스의 체 -> 조합으로 구하기
*/
import java.util.*;

class Solution {
    boolean[] isPrime;
    int answer = 0;
    int[] output = new int[3];

    public int solution(int[] nums) {
        Arrays.sort(nums);
        int[] bigNums = Arrays.copyOfRange(nums, nums.length-3, nums.length);
        int n = Arrays.stream(bigNums).sum();
        
        isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i=2; i<Math.sqrt(n)+1; i++) {
            if (isPrime[i]) {
                for (int j=i*i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        combination(0, 0, nums, nums.length);

        return answer;
    }

    private void combination(int start, int t, int[] nums, int m) {
        if (t == 3) {
            if (isPrime[Arrays.stream(output).sum()]) {
                answer++;
            }
            return;
        }
        
        for (int j = start; j < m; j++) {
            output[t] = nums[j];
            combination(j+1, t+1, nums, m);
        }
    }
}