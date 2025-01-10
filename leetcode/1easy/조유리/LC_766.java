public class LC_766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i=0; i<matrix.length; i++){
            int num = matrix[i][0];
            int nx = i+1;
            int ny = 0+1;
            while(inRange(nx, ny, matrix)){
                if(matrix[nx][ny] != num) return false;
                nx++; ny++;
            }
        }
        for(int j=0; j<matrix[0].length; j++){
            int num = matrix[0][j];
            int nx = 0+1;
            int ny = j+1;
            while(inRange(nx, ny, matrix)){
                if(matrix[nx][ny] != num) return false;
                nx++; ny++;
            }
        }
        return true;
    }

    public boolean inRange(int x, int y, int[][] matrix){
        return x>=0 && x<matrix.length && y>=0 && y < matrix[0].length;
    }
    
}
