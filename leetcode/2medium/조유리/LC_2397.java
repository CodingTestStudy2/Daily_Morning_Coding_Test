import java.util.ArrayList;
import java.util.List;

public class LC_2397 {
    class Solution {
        List<Integer> lst = new ArrayList<>();
        int maxNum = 0;

        public int maximumRows(int[][] matrix, int numSelect) {
            selectCol(numSelect, matrix);
            return maxNum;
        }

        // 선택된 Col을 제외하고 다 0으로 채워져 있는지 확인
        public int cnt(int[][] matrix){
            int ans = 0;
            for(int i=0; i<matrix.length; i++){
                boolean flag = true;
                for(int j=0; j<matrix[0].length; j++){
                    if(!lst.contains(j) && matrix[i][j] == 1){
                        flag = false;
                        break;
                    }
                }
                if(flag) ans++;
            }
            return ans;
        }

        // col을 numSelect개 구하기
        public void selectCol(int numSelect, int[][] matrix){
            if(lst.size() == numSelect){
                maxNum = Math.max(maxNum, cnt(matrix));
                return;
            }
            int lastIdx = lst.size() > 0 ? lst.get(lst.size()-1) : -1;
            for(int i=lastIdx + 1; i<matrix[0].length; i++){
                lst.add(i);
                selectCol(numSelect, matrix);
                lst.remove(lst.size()-1);
            }
        }
    }
}
