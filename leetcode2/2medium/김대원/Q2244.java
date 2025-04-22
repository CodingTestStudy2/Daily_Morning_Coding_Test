// 1. 아이디어 : 3으로 나누어지는지 판단하고, 경우의 수로 라운드 카운팅
// 2. 시간복잡도 : O(N)
// 3. 자료구조/알고리즘 : 그리디

class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : tasks) map.put(x, map.getOrDefault(x, 0) + 1);

        int round = 0;
        for (int k : map.keySet()) {
            int task = map.get(k);

            if (task == 1) return -1;

            if (task % 3 == 0) round += task / 3;
            else if (task % 3 == 1) round += (task / 3) - 1 + 2;
            else if (task % 3 == 2) round += task / 3 + 1;
        }

        return round;
    }
}