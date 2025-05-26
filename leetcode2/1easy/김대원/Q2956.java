/*
1. 아이디어 : map에 배열의 value를 key로 저장해서 존재하면 answer 증가
2. 시간복잡도 : O(N + M)
3. 자료구조/알고리즘 : 맵, 완탐
 */

class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] answer = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums2) map.put(x, 1);
        for (int x : nums1) answer[0] += map.getOrDefault(x, 0);

        map.clear();

        for (int x : nums1) map.put(x, 1);
        for (int x : nums2) answer[1] += map.getOrDefault(x, 0);

        return answer;
    }
}