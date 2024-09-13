import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int n=score.length;
        Integer[]arr=new Integer[n];
        for(int i=0;i<n;i++){
            arr[i]=score[i];
        }
        
        Arrays.sort(arr,new Comparator<>(){
            @Override
            public int compare(Integer o1,Integer o2){
                return o2-o1;
            }
        });
        
        for(int i=m-1;i<n;i+=m){
            answer+=arr[i]*m;
        }
        return answer;
    }
}
