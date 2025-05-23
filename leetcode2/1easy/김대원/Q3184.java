class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            int h = hours[i];
            int r = h % 24;

            if (r == 0) {
                if (map.containsKey(r)) {
                    answer += map.get(r);
                }

                map.put(r, map.getOrDefault(r, 0) + 1);
            } else {
                if (map.containsKey(r)) {
                    answer += map.get(r);
                }

                map.put(24 - r, map.getOrDefault(24 - r, 0) + 1);
            }
        }

        return answer;
    }
}