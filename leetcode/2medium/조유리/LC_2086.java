public class LC_2086 {
    class Solution {
        public int minimumBuckets(String h) {
            int ans = 0;
            if(h.equals("H") || h.startsWith("HH") || h.endsWith("HH") || h.contains("HHH")) return -1;
            // H.H 
            ans += h.length() - h.replace("H.H", "  ").length();
            // .HH. H..H
            h = h.replace("H.H", "");
            ans += h.length() - h.replace("H", "").length();
            return ans;
        }
    }
}
