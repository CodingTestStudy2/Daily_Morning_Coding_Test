class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0,Integer.MAX_VALUE};
        int start=0;
        int end=-1;
        int total=0;
        int n=sequence.length;
        while(true){
            if(total<k){
                if(end+1<n){
                    end++;
                }else{
                    break;
                }    
                total+=sequence[end];
            }else{
                total-=sequence[start++];
            }
            if(total==k){
                if(end-start<answer[1]-answer[0]){
                    answer[0]=start;
                    answer[1]=end;
                }
            }
            
        }
        return answer;
    }
}
