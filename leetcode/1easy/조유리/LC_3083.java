import java.util.HashSet;
import java.util.Set;

public class LC_3083 {
    class Solution {
        public boolean isSubstringPresent(String s) {
            Set<String> set = new HashSet<>();
            for(int i =0; i<s.length()-1; i++){
                set.add(s.substring(i, i+2));
            }


            StringBuilder sb = new StringBuilder(s);
            String rs = sb.reverse().toString();
            for(int i=0; i<rs.length()-1; i++){
                if(set.contains(rs.substring(i, i+2))) return true;
            }
            return false;
        }
    }
}