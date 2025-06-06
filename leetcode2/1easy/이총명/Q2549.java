class Solution {
    public int distinctIntegers(int n) {
        // n이 1이면, 1만 존재
        if(n == 1) {
            return 1;
        }
        // n이 1보다 크면, n, n-1 ..., 2까지 숫자가 모두 포함됨
        // => n - 1개
        return n - 1;
    }
}
