public class LC1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] prefixSum = new int[nums.length];

        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int ret = 0;

        int firstValue = 0, secondValue = 0;
        for (int i = -1; i + firstLen < nums.length; i++) {
            if (i == -1) firstValue = prefixSum[firstLen - 1];
            else firstValue = prefixSum[i + firstLen] - prefixSum[i];

            for (int j = -1; j + secondLen < i; j++) {
                if(j == -1) secondValue = prefixSum[j + secondLen];
                else secondValue = prefixSum[j + secondLen] - prefixSum[j];

                ret = Math.max(ret, firstValue + secondValue);

            }
            for (int j = i + firstLen; j + secondLen < nums.length; j++) {
                secondValue = prefixSum[j + secondLen] - prefixSum[j];

                ret = Math.max(ret, firstValue + secondValue);
            }
        }
        return ret;
    }
}
