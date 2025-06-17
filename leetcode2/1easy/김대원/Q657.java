class Solution {
    public boolean judgeCircle(String moves) {
        Queue<Character> queue = new LinkedList<>();
        for (char ch : moves.toCharArray()) {
            queue.offer(ch);
        }

        int[] result = new int[] {0, 0};
        while (!queue.isEmpty()) {
            char dir = queue.poll();
            if (dir == 'U') {
                result[0]++;
            } else if (dir == 'D') {
                result[0]--;
            } else if (dir == 'L') {
                result[1]--;
            } else {
                result[1]++;
            }
        }

        return result[0] == 0 && result[1] == 0;
    }
}