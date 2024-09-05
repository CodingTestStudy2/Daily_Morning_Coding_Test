import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<Integer,Integer>presentScore=new HashMap<>();
        Map<String,Integer>friendNum=new HashMap<>();
        int n=friends.length;
        int[][]present=new int[n][n];
        int max=-1;
        for(int i=0;i<friends.length;i++){
            friendNum.put(friends[i],i);
        }
        for(int i=0;i<gifts.length;i++){
            String[]gift=gifts[i].split(" ");
            int give=friendNum.get(gift[0]);
            int receive=friendNum.get(gift[1]);
            present[give][receive]+=1;
        }
        for(int i=0;i<n;i++){
            int score=0;
            for(int j=0;j<n;j++){
                score+=present[i][j];
            }
            for(int j=0;j<n;j++){
                score-=present[j][i];
            }
            presentScore.put(i,score);
        }
        
        
        
        for(int i=0;i<n;i++){
            int willrecieve=0;
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                int give=present[i][j];
                int recieve=present[j][i];
                if(give>recieve){
                    willrecieve+=1;
                }else if(give==recieve){
                    int givePresentScore=presentScore.get(i);
                    int recievePresentScore=presentScore.get(j);
                    if(givePresentScore>recievePresentScore){
                        willrecieve+=1;
                    }
                }
            }
            max=Math.max(max,willrecieve);
        }
        return max;
    }
}
