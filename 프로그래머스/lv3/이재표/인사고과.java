import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int a=scores[0][0];
        int b=scores[0][1];
        // 내림차순, 오름차순
        Arrays.sort(scores,new Comparator<int[]>(){
            @Override
            public int compare(int[]o1,int[]o2){
                if(o1[0]!=o2[0]){
                    return Integer.compare(o2[0],o1[0]);
                }else{
                    return Integer.compare(o1[1],o2[1]);
                }
            }
        });
        
        int maxScore=scores[0][1];
        for(int i=1;i<scores.length;i++){
            if(maxScore>scores[i][1]){
                if(scores[i][0]==a && scores[i][1]==b){
                    return -1;
                }
                scores[i][0]=-1;
                scores[i][1]=-1;
            }else{
                maxScore=scores[i][1];
            }
        }
        Arrays.sort(scores, (o1, o2) -> (o2[0] + o2[1]) - (o1[0] + o1[1]));
        int rank=0;
        for(int i=0;i<scores.length;i++){
            int sum=scores[i][0]+scores[i][1];
            if(sum>a+b){
                rank++;
            }else{
                break;
            }
        }
        return rank+1;
    }
}
