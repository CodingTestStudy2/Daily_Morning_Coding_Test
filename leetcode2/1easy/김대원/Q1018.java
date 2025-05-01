class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int divideNum = 5;
        List<Boolean> answer = new ArrayList<>();

        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            value = ((value << 1) + nums[i]) % 5;
            if (value == 0) answer.add(true);
            else answer.add(false);
            // if (value % divideNum == 0) answer.add(true);
            // else answer.add(false);
        }

        return answer;
    }
}
