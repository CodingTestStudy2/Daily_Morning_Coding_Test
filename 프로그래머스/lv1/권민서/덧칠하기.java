class Solution {

    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int wall = 1;
        int idx = 0;

        for (int i = 1; i < section.length; i++) {

            if (section[i] - section[idx] >= m) {
                answer++;
                wall = 1;
                idx = i;
            } else {
                if (wall >= m) {
                    answer++;
                    wall = 1;
                    idx = i;
                } else {
                    wall++;
                }
            }
        }
        return answer;
    }

}
