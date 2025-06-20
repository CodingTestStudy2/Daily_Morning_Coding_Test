class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];

        Map<Integer, Integer> idxs = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            idxs.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            int n1 = nums1[i];

            int result = -1;
            int idx = idxs.get(n1);
            for (int j = idx + 1; j < nums2.length; j++) {
                int n2 = nums2[j];
                if (n1 < n2) {
                    result = n2;
                    break;
                }
            }

            answer[i] = result;
        }

        return answer;
    }
}