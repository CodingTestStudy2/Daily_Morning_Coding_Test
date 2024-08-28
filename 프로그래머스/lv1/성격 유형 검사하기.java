import java.util.*;
class Solution {
    public String solution(String[] surveys, int[] choices) {
        String answer = "";
        int[][] scores=new int[][]{{0,3},{0,2},{0,1},{0,0},{1,1},{1,2},{1,3}};
        Map<Character,Integer>map=new HashMap<>();
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);
        for(int i=0;i<surveys.length;i++){
            char[] survey=surveys[i].toCharArray();
            int[]score=scores[choices[i]-1];
            char choiceAlp=survey[score[0]];
            map.put(choiceAlp,map.get(choiceAlp)+score[1]);
        }
        for(char key:map.keySet()){
            System.out.println(key+":"+map.get(key));
        }
        for(int i=0;i<4;i++){
            int scoreL;
            int scoreR;
            if(i==0){
                scoreL=map.get('R');
                scoreR=map.get('T');
                if(scoreL>=scoreR){
                    answer+='R';    
                }else{
                    answer+='T';
                }
            }else if(i==1){
                scoreL=map.get('C');
                scoreR=map.get('F');
                if(scoreL>=scoreR){
                    answer+='C';    
                }else{
                    answer+='F';
                }
            }else if(i==2){
                scoreL=map.get('J');
                scoreR=map.get('M');
                if(scoreL>=scoreR){
                    answer+='J';    
                }else{
                    answer+='M';
                }
            }else if(i==3){
                scoreL=map.get('A');
                scoreR=map.get('N');
                if(scoreL>=scoreR){
                    answer+='A';    
                }else{
                    answer+='N';
                }
            }
        }
        return answer;
    }
}
