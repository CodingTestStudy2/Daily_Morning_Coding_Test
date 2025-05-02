class Solution {
    public int findKOr(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        String bn = Integer.toBinaryString(max);
        int[] ch = new int[bn.length()];

        for (int num : nums) {
            String binary = Integer.toBinaryString(num);
            char[] bnChars = binary.toCharArray();

            int size = bnChars.length - 1;
            int maxSize = ch.length - 1;
            while (size >= 0) {
                if (bnChars[size] == '1') ch[maxSize]++;
                size--;
                maxSize--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int cnt : ch) {
            if (cnt >= k) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        return Integer.parseInt(sb.toString(), 2);
    }
}