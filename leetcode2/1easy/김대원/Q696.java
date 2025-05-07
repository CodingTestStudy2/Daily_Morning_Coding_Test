class Solution {
    public int countBinarySubstrings(String s) {
        int answer = 0;
        int p1 = 0, p2 = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                p2++;
            } else {
                p1 = p2;
                p2 = 1;
            }

            if (p1 >= p2) answer++;
        }

        return answer;
    }
}