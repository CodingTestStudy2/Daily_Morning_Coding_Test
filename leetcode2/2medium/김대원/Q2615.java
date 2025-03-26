// 1. 아이디어 : Hash에 index를 저장하고 거리 판별 최적화
// 2. 시간복잡도 : O(NlogN)
// 3. 자료구조/알고리즘 : Hash, 투포인터(?), 이분탐색(?)

class Solution {

    Map<Integer, List<Integer>> map = new HashMap<>();

    public long[] distance(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        long[] answer = new long[nums.length]
        for (List<Integer> idxs : map.values()) {
            int size = idxs.size();
            if (size <= 2) continue;
            int p1 = 0;

            for (int p2 = 0; p2 < size; p2++) {

            }
        }
    }
}