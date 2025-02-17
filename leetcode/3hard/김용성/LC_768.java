public class LC_768 {
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int[] maxOfLeftBound = new int[arr.length];
            int[] minOfRightBound = new int[arr.length];

            maxOfLeftBound[0] = arr[0];
            for (int i = 1; i < arr.length - 1; i++) {
                maxOfLeftBound[i] = Math.max(maxOfLeftBound[i - 1], arr[i]);
            }

            minOfRightBound[arr.length - 1] = arr[arr.length - 1];
            for(int i = arr.length - 2; i >= 0; i--) {
                minOfRightBound[i] = Math.min(minOfRightBound[i + 1], arr[i]);
            }

            int ret = 1;

            for(int i=0; i<arr.length-1; i++) {
                if(maxOfLeftBound[i] <= minOfRightBound[i+1]) {
                    ret++;
                }
            }

            return ret;
        }
    }
}
