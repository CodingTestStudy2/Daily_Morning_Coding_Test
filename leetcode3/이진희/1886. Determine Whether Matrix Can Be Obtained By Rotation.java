/* 

1. 아이디어 : mat을 90, 180, 270, 360도로 배열을 회전했을때 target과 일치하면 true, 아니면 false
              배열 회전 공식을 사용한다. 

2. 시간복잡도 : O(N^2*3)

3. 자료구조/알고리즘 : 완전탐색

 */

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {

        boolean check;
        int n = mat.length;

        // 90도 회전해서 가능하면 true
        for(int cnt=0; cnt<4; cnt++) {
            if(cnt>0) mat = rotate90(mat, n);

            check = true;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(target[i][j] != mat[i][j]) check = false;
                }
            } 

            if(check == true) return true;
        } 

        return false;
    }

    private int[][] rotate90(int[][] mat, int n) {

        int[][] rotated = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                rotated[j][n-1-i] = mat[i][j];
            }
        }

        return rotated;
    }
}