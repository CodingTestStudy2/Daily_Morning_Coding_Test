// 1. 아이디어 : 요소 갯수를 카운팅하고 최대값들 합치기
// 2. 시간복잡도 : O(N)
// 3. 자료구조/알고리즘 : map

class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, map.get(num));
        }

        int answer = 0;
        for (int value : map.values()) {
            if (value == max) answer += value;
        }

        return answer;
    }
}