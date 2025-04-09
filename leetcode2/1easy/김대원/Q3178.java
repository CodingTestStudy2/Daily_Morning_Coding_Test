class Solution {
    public int numberOfChild(int n, int k) {
        int cur = 0;
        if ((k / (n - 1)) % 2 == 0) {
            cur = k % (n - 1);
        } else {
            cur = (n - 1) - (k % (n - 1));
        }

        return cur;
    }
}