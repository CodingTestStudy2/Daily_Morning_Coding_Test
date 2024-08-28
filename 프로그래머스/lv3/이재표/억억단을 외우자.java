class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int idx=0;
        int[]freq=new int[e+1];
        int[]arr=new int[e+1];
        for(int i=1;i<=e;i++){
            for(int j=1;i*j<=e;j++){
                arr[i*j]+=1;
            }
        }
        int maxD=0;
        int maxI=0;
        for(int j=e;j>=1;j--){
            if(arr[j]>=maxD){
                maxD=arr[j];
                maxI=j;
            }
            freq[j]=maxI;
        }
        for(int i=0;i<starts.length;i++){
            answer[i]=freq[starts[i]];
        }
        return answer;
    }
}
