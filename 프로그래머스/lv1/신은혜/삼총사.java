class Solution {
    public int solution(int[] number) {
        int result=0;
        for(int i=0; i<(1<<number.length); i++){
            int sum=0;
            int cnt=0;
            for(int j=0; j<number.length; j++){
                if((i&(1<<j))!=0){
                    cnt++;
                    sum+=number[j];
                }
            }
            if(cnt==3&&sum==0)
                result++;         
        }
        return result;
    }
}
