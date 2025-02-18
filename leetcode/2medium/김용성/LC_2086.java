public class LC_2086 {
    class Solution {
        public int minimumBuckets(String hamsters) {
            int[] food = new int[hamsters.length()];
            int ret = 0;
            for (int i = 0; i < hamsters.length(); i++) {
                if (hamsters.charAt(i) == 'H') {
                    int prev = i - 1;
                    int next = i + 1;

                    if (prev >= 0 && food[prev] != 0) {
                        continue;
                    } else if (next < hamsters.length() && hamsters.charAt(next) == '.') {
                        food[next]++;
                        ret++;
                    } else if (prev >= 0 && hamsters.charAt(prev) == '.') {
                        food[prev]++;
                        ret++;
                    } else {
                        return -1;
                    }
                }

            }
            return ret;
        }
    }
}
