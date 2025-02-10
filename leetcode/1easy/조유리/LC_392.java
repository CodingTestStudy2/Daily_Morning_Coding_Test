public class LC_392 {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            // s가 t안에 있는지?
            int i = 0 ;
            for(int j=0; j<t.length(); j++){
                if(i >= s.length()) break;
                if(s.charAt(i) == t.charAt(j)){
                    i++;
                }
            }
            if(i == s.length()) return true;
            return false;
        }
    }
}