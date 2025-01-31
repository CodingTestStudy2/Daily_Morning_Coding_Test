public class LC_1901 {
    public int[] findPeakGrid(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int start_col = 0, end_col = col-1;

        while(start_col <= end_col){
            int mid_col = (start_col + end_col) / 2;

            // 중간 값
            int max_row = 0;
            for(int i=0; i<row; i++){
                if(mat[i][mid_col] > mat[max_row][mid_col]) max_row = i;
            }

            // peak 여부 확인 및 이동(더 큰 값이 있다면, 그 곳으로 이동한다.)
            int val = mat[max_row][mid_col];
            int left = mid_col > 0 ? mat[max_row][mid_col-1] : -1;
            int right = mid_col < col-1 ? mat[max_row][mid_col+1] : -1;
            if(val > left && val > right){
                return new int[]{max_row, mid_col};
            }
            else if(left > val){
                end_col = mid_col - 1;
            }
            else{
                start_col = mid_col + 1;
            }
        }
        return null;
    }
}
