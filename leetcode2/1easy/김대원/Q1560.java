// 1. 아이디어 : 현재 round의 위치를 비교해서 거쳐가는 섹터 갯수 판단
// 2. 시간복잡도 : O(N + M)
// 3. 자료구조/알고리즘 :


class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] result = new int[n + 1];
        int prev = rounds[0];
        result[prev]++;
        for (int i = 1; i < rounds.length; i++) {
            int round = rounds[i];

            if (round < prev) {
                for (int j = prev + 1; j <= n; j++) result[j]++;
                for (int j = 1; j <= round; j++) result[j]++;
            } else {
                for (int j = prev + 1; j <= round; j++) result[j]++;
            }

            prev = round;
        }

        List<Integer> answer = new ArrayList<>();
        int max = Arrays.stream(result).max().getAsInt();
        for (int i = 1; i <= n; i++) {
            if (result[i] == max) answer.add(i);
        }

        return answer;
    }
}