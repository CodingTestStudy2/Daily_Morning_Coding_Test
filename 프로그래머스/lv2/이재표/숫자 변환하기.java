import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[]arr=new int[y+1];
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[x]=0;
        for(int i=x;i<=y;i++){
            if(arr[i]==Integer.MAX_VALUE){
                continue;
            }
            if(i+n<=y){
                arr[i+n]=Math.min(arr[i+n],arr[i]+1);
            }
            if(i*2<=y){
                arr[i*2]=Math.min(arr[i*2],arr[i]+1);
            }
            if(i*3<=y){
                arr[i*3]=Math.min(arr[i*3],arr[i]+1);
            }
        }
        if(arr[y]==Integer.MAX_VALUE){
            return -1;
        }
        return arr[y];
    }
}
