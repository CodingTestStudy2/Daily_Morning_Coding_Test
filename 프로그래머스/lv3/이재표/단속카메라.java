import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes,new Comparator<>(){
            @Override
            public int compare(int[]o1,int[]o2){
                return o1[0]-o2[0];
            }
        });
        int answer=1;
        int start=routes[0][0];
        int end=routes[0][1];
        for(int i=1;i<routes.length;i++){
            int route_start=routes[i][0];
            int route_end=routes[i][1];
            if(route_start<=end){
                start=route_start;
                if(route_end<=end){
                    end=route_end;
                }
            }else{
                start=route_start;
                end=route_end;
                answer++;
            }
        }
        return answer;
    }
}
