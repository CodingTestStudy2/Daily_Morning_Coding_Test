class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            int[] domione = dominoes[i];
            String key = domione[0] + " " + domione[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int answer = 0;
        for (int i = 0; i < dominoes.length; i++) {
            int[] domione = dominoes[i];
            String key = domione[0] + " " + domione[1];
            String reverse = domione[1] + " " + domione[0];

            answer += map.get(key) - 1;
            map.replace(key, map.get(key) - 1);
            if (!key.equals(reverse) && map.containsKey(reverse)) answer += map.get(reverse);
        }

        return answer;
    }
}
