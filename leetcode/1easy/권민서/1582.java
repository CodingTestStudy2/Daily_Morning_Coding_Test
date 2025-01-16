import java.util.*;

class Solution {
    public int numSpecial(int[][] mat) {
        int answer = 0;

        for (int i = 0; i < mat.length; i++) {
            for(int j = 0 ; j < mat[i].length ; j++) {
                if(mat[i][j] == 1) {
                    boolean flag = true;
                    //열 검사
                    for(int x = 0 ; x < mat.length; x++) {
                        if(x == i) continue;
                        if(mat[x][j] == 1) {
                            flag = false;
                            break;
                        }
                    }
                    // 행검사
                    for (int y = 0; y < mat[i].length; y++) {
                        if(y == j) continue;
                        if(mat[i][y] == 1) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) answer++;
                }
            }
        }
        return answer;
    }
}