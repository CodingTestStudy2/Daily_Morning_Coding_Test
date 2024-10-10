/**
단순 정렬
*/
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        
        for (var i=0; i<n; i++) {
            int start = commands[i][0]-1, end = commands[i][1]-1, k = commands[i][2]-1;
            int[] newArray = Arrays.copyOfRange(array, start, end+1);
            Arrays.sort(newArray);
            answer[i] = newArray[k];
        }
        
        return answer;
    }
}