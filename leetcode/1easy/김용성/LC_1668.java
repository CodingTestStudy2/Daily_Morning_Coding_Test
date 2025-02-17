public class LC_1668 {
    class Solution {
        public int maxRepeating(String sequence, String word) {
            StringBuilder tmp = new StringBuilder(word);
            int count = 0;
            while (sequence.contains(tmp.toString())) {
                tmp.append(word);
                count++;
            }
            return count;
        }
    }
}