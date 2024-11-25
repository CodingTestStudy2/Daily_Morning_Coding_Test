import java.util.*;
class Solution {
    int[][]arr;
    public int[] solution(int n) {
        arr = new int[n][n];
        int r = -1;
        int c = 0;
        int num = 1;
        int len = n;
        while (len > 0) {
            for (int i = 0; i < len; i++) {
                arr[++r][c] = num++;
            }//아래
            len--;
            for (int i = 0; i < len; i++) {
                arr[r][++c] = num++;
            }//오른쪽
            len--;
            for (int i = 0; i < len; i++) {
                arr[--r][--c] = num++;
            }//좌상
            len--;
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    break;
                }
                answer.add(arr[i][j]);
            }
        }
        int[] array = answer.stream().mapToInt(Integer::intValue).toArray();
        return array;
    }
}
