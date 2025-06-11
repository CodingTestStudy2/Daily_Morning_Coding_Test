class Solution {
    public int minChanges(int n, int k) {
        if (n == k) return 0;
        int result = n & k;
        if (result == k) {
            String nb = Integer.toBinaryString(Math.abs(n - k));
            int answer = 0;
            for (char ch : nb.toCharArray()) {
                if (ch == '1') answer++;
            }

            return answer;
        }

        return -1;
    }
}
