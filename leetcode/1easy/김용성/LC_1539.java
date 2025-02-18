public class LC_1539 {
    class Solution {
        public static final int MAX = 2001;

        public int findKthPositive(int[] arr, int k) {
            int[] missingArr = new int[MAX];
            for (int i = 0; i < arr.length; i++) {
                missingArr[arr[i]]++;
            }

            for (int i = 1; i < MAX; i++) {
                if (missingArr[i] == 0) {
                    k--;
                    if (k == 0) return i;
                }
            }
            return -1;
        }
    }
}
