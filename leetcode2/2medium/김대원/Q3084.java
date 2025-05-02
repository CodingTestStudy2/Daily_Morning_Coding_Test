class Solution {
    public long countSubstrings(String s, char c) {
        long charCount = 0;
        for (char x : s.toCharArray()) {
            if (x == c) charCount++;
        }

        long answer = charCount + (charCount * (charCount - 1) / 2);
        return answer;
    }
}