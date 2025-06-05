'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    public long solution(int n) {
        if (n<=2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i=2; i<n; i++) {
            dp[i] = (dp[i-2]+dp[i-1]) % 1234567;
        }
        return dp[n-1];
    }
}



'''


