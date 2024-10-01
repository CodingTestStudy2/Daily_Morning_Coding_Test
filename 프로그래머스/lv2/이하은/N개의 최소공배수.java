class Solution {
    public int solution(int[] arr) {
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ans = lcm(ans, arr[i]); 
        }
        return ans;
    }
    
    int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    
    int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}