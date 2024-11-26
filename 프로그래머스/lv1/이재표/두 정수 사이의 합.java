class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        if(a==b){
            return a;
        }
        int start;
        int end;
        if(a>b){
            start=b;
            end=a;
        }else{
            start=a;
            end=b;
        }
        for(int i=start;i<=end;i++){
            answer+=i;
        }
        return answer;
    }
}
