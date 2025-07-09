class Solution {
    public int minPartitions(String n) {
        int answer = 0;
        int size = n.length();
        for (int i = 0; i < size; i++) {
            if (n.charAt(i) - '0' == 0) continue;
            answer = Math.max(answer, n.charAt(i) - '0');
        }

        return answer;
    }
}
