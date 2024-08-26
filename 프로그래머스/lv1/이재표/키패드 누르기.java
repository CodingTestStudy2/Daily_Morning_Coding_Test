import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb=new StringBuilder();
        int lastL=10;
        int lastR=12;
        for(int i=0;i<numbers.length;i++){
            int input=numbers[i];
            if(numbers[i]==0){
                input=11;
            }
            if(input==1 || input==4 || input==7){
                lastL=input;
                sb.append('L');
            }else if(input==3 || input==6 || input==9){
                lastR=input;
                sb.append('R');
            }else{
                int leftD = Math.abs(input- lastL) / 3 + Math.abs(input - lastL) % 3;
                int rightD = Math.abs(input - lastR) / 3 + Math.abs(input - lastR) % 3;
                if(leftD>rightD){
                    lastR=input;
                    sb.append('R');
                }else if(leftD<rightD){
                    lastL=input;
                    sb.append('L');
                }else{
                    if(hand.equals("right")){
                        lastR=input;
                        sb.append('R');
                    }else{
                        lastL=input;
                        sb.append('L');
                    }
                }
            }
        }    
    
        return sb.toString();
    }
}
