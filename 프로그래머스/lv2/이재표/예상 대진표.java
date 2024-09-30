import java.util.*;
class Solution{
    public int solution(int n, int a, int b){
        int answer = 0;
        Queue<int[]>q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.offer(new int[]{i,0});
        }
        while(!q.isEmpty()){
            int[]p1=q.poll();
            int[]p2=q.poll();
            if( (p1[0]==a || p1[0]==b) && (p2[0]==a||p2[0]==b)){
                return p1[1]+1;
            }
            if((p2[0]==a||p2[0]==b)){
                q.offer(new int[]{p2[0],p2[1]+1});
            }else{
                q.offer(new int[]{p1[0],p1[1]+1});
            }
        }
        return -1;
    }
}
