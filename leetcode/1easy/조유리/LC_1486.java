public class LC_1486 {
    public int xorOperation(int n, int start) {
        int ans = start;
        for(int i=1; i<n; i++){
            ans ^= (start + i*2);
        }
        return ans;
    }
}