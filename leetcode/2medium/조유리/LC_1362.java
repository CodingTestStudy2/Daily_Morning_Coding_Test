public class LC_1362 {
    class Solution {
        public int[] closestDivisors(int num) {
            int[] a = find(num+1);
            int[] b = find(num+2);
            int aDiff = Math.abs(a[0] - a[1]);
            int bDiff = Math.abs(b[0] - b[1]);
            if(aDiff <= bDiff) return a;
            else return b;
        }
    
        public int[] find(int num){
            int[] ans = new int[2];
            for(int i=1; i*i<= num; i++){
                if(num % i == 0){
                    ans[0] = i;
                    ans[1] = num / i;
                }
            }
            return ans;
        }
    }
}