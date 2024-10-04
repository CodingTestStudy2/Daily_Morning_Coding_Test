import java.util.*;

/*
9 = 2 * 4 + 1 
4 = 2 * 2 + 0
2 = 2 * 1 + 0 
*/
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        // 10진수로 2진수로 변환
        Integer[][] map1 = convertBinary(n, arr1);
        Integer[][] map2 = convertBinary(n, arr2);
        
        // 적어도 하나가 벽이면 벽으로
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j < n; j++){
                if(map1[i][j] == 1 || map2[i][j] == 1){
                    sb.append("#");
                }else{
                    sb.append(" ");
                }
            }
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    
    Integer[][] convertBinary(int n, int[] arr){
        Integer[][] board = new Integer[n][n];
        
        for(int i = 0; i < arr.length; i++){
            int temp = arr[i];
            ArrayList<Integer> result = new ArrayList<>();
            
            while(temp >= 2){
                result.add(temp % 2);
                temp /= 2;
            }
            result.add(temp);
            
            // 자리수 n으로 맞추기 
            while(result.size() < n) result.add(0);
            
            Collections.reverse(result);
            
            board[i] = result.toArray(new Integer[n]);
        }
        
        return board;
    }
}