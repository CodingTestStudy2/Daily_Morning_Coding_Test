package Leetcode.염류선;


class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] answer = new int[2];
        int same = 0;
        int min = Math.min(nums1.length, nums2.length);
        for (int i = 0; i < nums1.length; i ++) {
            for (int j = 0; j < nums2.length; j ++) {
                if (nums1[i] == nums2[j]) {
                    same++;
                    break;
                }
            }
        }
        answer[0] = same;

        same = 0;
        for (int i = 0; i < nums2.length; i ++) {
            for (int j = 0; j < nums1.length; j ++) {
                if (nums2[i] == nums1[j]) {
                    same++;
                    break;
                }
            }
        }
        answer[1] = same;
        return answer;
    }
}
