class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (s.length() > t.length() || t.length() == 0) return false;

        int idx = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(idx) == t.charAt(i)) {
                idx++;
            }

            if (idx >= s.length()) {
                break;
            }
        }

        return idx >= s.length();
    }
}