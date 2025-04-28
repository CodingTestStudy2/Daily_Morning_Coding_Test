class Solution {
    public int minimumLevels(int[] possible) {
        int n = possible.length;
        int total = 0;
        for (int x : possible) {
            if (x == 0) {
                total--;
            } else {
                total++;
            }
        }

        int alice = possible[0] == 0 ? -1 : 1;
        int bob = total - alice;
        int answer = Integer.MAX_VALUE;
        if (alice > bob) answer = Math.min(1, answer);
        for (int round = 1; round < n - 1; round++) {
            alice += possible[round] == 0 ? -1 : 1;
            bob = total - alice;
            if (alice > bob) answer = Math.min(round + 1, answer);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}