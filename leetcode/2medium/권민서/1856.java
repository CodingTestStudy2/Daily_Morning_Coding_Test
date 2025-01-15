class Solution {
    public static int maxSumMinProduct(int[] nums) {
        int n = nums.length;

        // 누적 합 배열 생성
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // 왼쪽 경계 계산
        int[] left = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // 오른쪽 경계 계산
        int[] right = new int[n];
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // 최대 곱 계산
        long maxProduct = 0;
        for (int i = 0; i < n; i++) {
            long sum = prefixSum[right[i]] - prefixSum[left[i] + 1];
            maxProduct = Math.max(maxProduct, sum * nums[i]);
        }

        // 결과 반환 (모듈로 연산)
        return (int) (maxProduct % 1_000_000_007);
    }

}