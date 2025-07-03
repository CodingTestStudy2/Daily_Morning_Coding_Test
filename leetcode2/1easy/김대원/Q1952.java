class Solution {
    public boolean isThree(int n) {
        double sqrt = Math.sqrt(n);
        if (sqrt % 1 != 0.0) return false;

        for (int i = 2; i <= Math.sqrt(sqrt); i++) {
            if (sqrt % i == 0) return false;
        }

        return sqrt > 1;
    }
}

// 1 <= n <= 10^4
// n = k * m