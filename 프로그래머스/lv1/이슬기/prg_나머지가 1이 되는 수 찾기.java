/**
n을 x로 나눈 나머지 = 1
*/

class Solution {
    public int solution(int n) {
        for (var i=2; i<=n; i++) {
            if (n % i == 1) {
                return i;
            }
        }
        return n;
    }
}