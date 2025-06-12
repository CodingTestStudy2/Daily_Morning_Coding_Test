class Solution {
    public int smallestIndex(int[] nums) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (numOfDigit(nums[i]) == i) {
                answer = i;
                break;
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private int numOfDigit(int num) {
        int result = 0;
        while (num != 0) {
            result += num % 10;
            num /= 10;
        }

        return result;
    }
}

//  1 <= nums.length <= 100
//  0 <= nums[i] <= 1000