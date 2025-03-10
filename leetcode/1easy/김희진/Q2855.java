public class Q2855 {

    public int minimumRightShifts(List<Integer> nums) {
        int dropCount = 0;
        int dropIndex = 0;
        int numsSize = nums.size();

        if (numsSize == 1) {
            return 0;
        }

        for (int i = 1; i < numsSize; ++i) {
            if (nums.get(i-1) > nums.get(i)) {
                dropIndex = i;
                dropCount++;

                if (dropCount > 1) {
                    return -1;
                }
            }
        }

        if (dropCount == 0) {
            return 0;
        }

        return nums.get(numsSize-1) > nums.get(0) ? -1 : numsSize - dropIndex;
    }

}
