public class Q1608 {

    public int specialArray(int[] nums) {
        // Sort the array to enable binary search
        Arrays.sort(nums);
        int n = nums.length; // Get the length of the sorted array

        // Iterate through possible values of x
        for (int x = 1; x <= n; ++x) {
            int left = 0; // Initialize left pointer of binary search
            int right = n; // Initialize right pointer of binary search

            // Perform binary search to find the first position where the value is >= x
            while (left < right) {
                int mid = (left + right) >> 1; // Calculate the middle index
                if (nums[mid] >= x) {
                    // If mid value is >= x, shrink the right end of the search range
                    right = mid;
                } else {
                    // If mid value is < x, shrink the left end of the search range
                    left = mid + 1;
                }
            }

            // Calculate the count of numbers >= x
            int countGreaterOrEqualX = n - left;

            // If the count of numbers >= x equals x, we found the special value
            if (countGreaterOrEqualX == x) {
                return x; // Return the special value of x
            }
        }

        // If no special value is found, return -1
        return -1;
    }

}
