class Solution {
    public boolean equalFrequency(String word) {
        int[] cnt = new int[26];
        for (int i = 0; i < word.length(); i++) {
            cnt[word.charAt(i) - 'a']++;
        }

        for (int i = 0; i < word.length(); i++) {
            int[] subCnt = cnt.clone();
            subCnt[word.charAt(i) - 'a']--;

            int posValue = -1;
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                int val = subCnt[j];
                if (val == 0) continue;
                if (posValue == -1) {
                    posValue = val;
                    continue;
                }

                if (posValue != val) {
                    flag = false;
                    break;
                }
            }

            if (flag) return true;
        }

        return false;
    }
}