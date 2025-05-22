class Solution {
    public String maximumOddBinaryNumber(String s) {
        int[] ch = new int[2];
        for (char c : s.toCharArray()) {
            if (c == '0') ch[0]++;
            else ch[1]++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("1");
        ch[1]--;
        for (int i = 0; i < s.length() - 1; i++) {
            if (ch[0] != 0) {
                sb.insert(0, "0");
                ch[0]--;
            } else {
                sb.insert(0, "1");
            }
        }

        return sb.toString();
    }
}