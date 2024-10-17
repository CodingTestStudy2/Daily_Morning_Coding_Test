import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max=0;
        int pos=0;
        int idx=0;
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0]>max){
                max=sizes[i][0];
                pos=i;
                idx=0;
            }
            if(sizes[i][1]>max){
                max=sizes[i][1];
                pos=i;
                idx=1;
            }
        }
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][idx]<sizes[i][(idx+1)%2]){
                int tmp=sizes[i][idx];
                sizes[i][idx]=sizes[i][(idx+1)%2];
                sizes[i][(idx+1)%2]=tmp;
            }
        }
        int maxR=0;
        int maxC=0;
        for(int i=0;i<sizes.length;i++){
            maxR=Math.max(sizes[i][0],maxR);
            maxC=Math.max(sizes[i][1],maxC);
        }
        return maxR*maxC;
    }
}
