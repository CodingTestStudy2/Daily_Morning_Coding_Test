import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        // 공통으로 나타나는 정수 k 를 이용해서 만들 수 있는 가장 큰 정수를 두 수의 짝꿍
        // 존재하지 않으면, 짝꿍 -1

        int[] xList = cntInt(X);
        int[] yList = cntInt(Y);
        System.out.println(Arrays.toString(xList));
        System.out.println(Arrays.toString(yList));
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < 10; i++) {
            if (xList[i] != 0 && yList[i] != 0 ) {
                int iterCnt =Math.min(xList[i], yList[i]);
                for (int j = 0; j < iterCnt ; j++){
                    sb.append(9-i);
                }
            }
        }

        String answer = sb.toString();

        if(answer.equals("")){
            return "-1";
        }
        if(answer.charAt(0) == '0'){
            return "0";
        }
        return answer;
    }

    private int[] cntInt(String x) {
        int[] temp = new int[10];
        for (int i = 0 ; i < x.length() ; i++) {
            temp[9 - (x.charAt(i) - '0')]++;
        }
        return temp;
    }
}