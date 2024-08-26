import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        Map<Integer, int[]> map = new HashMap<>();
        map.put(1, new int[]{-1,3});
        map.put(2, new int[]{0,3});
        map.put(3, new int[]{1,3});
        map.put(4, new int[]{-1,2});
        map.put(5, new int[]{0,2});
        map.put(6, new int[]{1,2});
        map.put(7, new int[]{-1,1});
        map.put(8, new int[]{0,1});
        map.put(9, new int[]{1,1});
        map.put(0, new int[]{0,0});
  
        int[] rPlace = {1,0};
        int[] lPlace = {-1,0};
        StringBuilder sb = new StringBuilder();
        int [] lside= {1,4,7};
        int [] rside= {3,6,9};
        
        for(int i=0; i<numbers.length; i++){
            int num = numbers[i];
            int[] next = map.get(num);
            
            if(Arrays.stream(lside).anyMatch((n)-> num==n)){
                sb.append("L");
                lPlace = map.get(num);
            }else if(Arrays.stream(rside).anyMatch((n)-> num==n)){
                sb.append("R");
                rPlace = map.get(num);
            }else{
                int ld = Math.abs(lPlace[0]-next[0])+ Math.abs(lPlace[1]-next[1]);
                int rd = Math.abs(rPlace[0]-next[0])+ Math.abs(rPlace[1]-next[1]);

                if(ld>rd){ // 오른손이 가까울 경우
                    sb.append("R");
                    rPlace = map.get(num);
                }else if(ld<rd){ // 왼손이 가까울 경우
                    sb.append("L");
                    lPlace = map.get(num);
                }else{ //같을 경우
                    if(hand.equals("right")){
                        sb.append("R");
                        rPlace = map.get(num);
                    }else{
                        sb.append("L");
                        lPlace = map.get(num);
                    }
                }
            }
            
        }
        
        answer = sb.toString();
        return answer;
    }
}
