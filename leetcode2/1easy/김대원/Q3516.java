class Solution {
    public int findClosest(int x, int y, int z) {
        int r1 = Math.abs(x - z), r2 = Math.abs(y - z);
        return r1 == r2 ? 0 : (r1 < r2 ? 1 : 2);
    }
}