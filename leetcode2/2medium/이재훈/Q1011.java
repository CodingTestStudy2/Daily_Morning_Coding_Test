package 이재훈;

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int answer = Integer.MAX_VALUE;
        int lt = Arrays.stream(weights).max().getAsInt();
        int rt = Arrays.stream(weights).sum();
        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            int day = 1;
            int sum = 0;
            for (int weight : weights) {
                if (sum + weight > mid) {
                    day++;
                    sum = 0;
                }

                sum += weight;
            }

            if (day > days) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
                answer = Math.min(answer, mid);
            }
        }

        return answer;
    }
}

// 1 <= days <= weights.length <= 5 * 10^4