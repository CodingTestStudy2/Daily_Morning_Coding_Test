public class Q1995 {

    public String getSmallestString(String s) {
        char[] nums = s.toCharArray();

        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i] - '0';
            int b = nums[i + 1] - '0';

            if ((a % 2 == b % 2) && (a > b)) {
                char temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
                return new String(nums);
            }
        }

        return s;
    }

}
