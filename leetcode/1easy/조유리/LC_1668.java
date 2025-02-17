public class LC_1668 {
    class Solution {
        public int maxRepeating(String sequence, String word) {
            String sub = word;
            int ans = 0;
            while(sub.length() <= sequence.length()){
                if(!sequence.contains(sub)) return ans;
                sub += word;
                ans++;
            }
            return ans > 0 ? ans : 0;
        }
    }
}
