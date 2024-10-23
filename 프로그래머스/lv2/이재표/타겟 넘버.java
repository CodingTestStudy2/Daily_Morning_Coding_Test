class Solution {
    int[]nums;
    int tar;
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        nums=numbers;
        tar=target;
        dfs(0,0);
        return answer;
    }
    private void dfs(int total,int index){
        if(index==nums.length){
            if(total==tar){
                answer++;        
            }
            return;
        }
        dfs(total-nums[index],index+1);
        dfs(total+nums[index],index+1);
    }
}
