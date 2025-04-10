class Solution {

    static Set<Integer> answer;

    public int countDifferentSubsequenceGCDs(int[] nums) {
        answer = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            answer.add(nums[i]);
            search(i + 1, nums[i], nums);
        }
        // System.out.println(answer);

        return answer.size();
    }

    private void search(int idx, int gcd, int[] nums) {
        if (idx >= nums.length) return;

        search(idx + 1, gcd, nums);

        gcd = getGcd(gcd, nums[idx]);
        answer.add(gcd);
        search(idx + 1, gcd, nums);
    }

    private int getGcd(int num1, int num2) {
        int min = Math.min(num1, num2);
        int gcd = 0;
        for (int i = 1; i <= min; i++) {
            if (num1 % i == 0 && num2 % i == 0) gcd = i;
        }

        return gcd;
    }
}

// 1 <= nums.length <= 10^5
// 부분집합 GCD 개수. -> 모든 집합을 만들어내는 것은 시간초과
