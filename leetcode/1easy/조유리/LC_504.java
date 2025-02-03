public class LC_504 {
    class Solution {
        public String convertToBase7(int num) {
            int a = Math.abs(num);
    
            StringBuilder ans = new StringBuilder();
            while(a > 0){
                ans.insert(0, String.valueOf(a % 7));
                a = a / 7;
            }
    
            if(num < 0) ans.insert(0, "-");
            if(num == 0) return "0";
            return ans.toString();
        }
    }
}