// 1. 아이디어 :
// 2. 시간복잡도 :
// 3. 자료구조/알고리즘 :

class Solution {
    public int captureForts(int[] forts) {
        int n = forts.length;
        int answer = 0;

        int tmp = 0;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 1) {
                flag = true;
                tmp = 0;
            } else if (forts[i] == 0) {
                if (flag) {
                    tmp++;
                }
            } else {
                if (flag) {
                    answer = Math.max(answer, tmp);
                    flag = false;
                }
            }
        }

        tmp = 0;
        flag = false;
        for (int i = n - 1; i >= 0; i--) {
            if (forts[i] == 1) {
                flag = true;
                tmp = 0;
            } else if (forts[i] == 0) {
                if (flag) {
                    tmp++;
                }
            } else {
                if (flag) {
                    answer = Math.max(answer, tmp);
                    flag = false;
                }
            }
        }

        return answer;
    }
}