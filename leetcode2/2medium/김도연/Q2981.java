package Leetcode.김도연;

public class Q2981  {
    public int maximumLength(String s) {
        int n = s.length();
        int left = 1, right = n;
        int answer = -1;

        while (left <= right) {
            int mid = (left+right) / 2;
            if (canFind(s, mid)) {
                answer = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return answer;
    }

    private boolean canFind(String s, int len) {
        int n = s.length();
        int[] count = new int[26];
        int i = 0;

        while (i < n) {
            char c = s.charAt(i);
            int j = i;

            while (j < n && s.charAt(j) == c)
                j++;

            int blockLen = j - i;
            if (blockLen >= len) {
                count[c - 'a'] += blockLen - len + 1;
                if (count[c- 'a'] >= 3)
                    return true;
            }
            i = j;
        }
        return false;
    }
}
