class Solution {
    public int solution(int number, int limit, int power) {
        int[]arr=new int[number+1];
        for(int i=1;i<=number;i++){
            int mul=1;
            while(mul*i<=number){
                arr[i*mul]+=1;
                mul++;
            }
        }
        
        int answer = 0;
        for(int i=1;i<=number;i++){
            if(arr[i]<=limit){
                answer+=arr[i];
            }else{
                answer+=power;
            }
        }
        
        return answer;
    }
}
