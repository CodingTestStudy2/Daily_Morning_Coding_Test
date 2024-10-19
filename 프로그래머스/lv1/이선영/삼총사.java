class Solution {
    static int answer = 0;
    public int solution(int[] number) {
        
        boolean[] selected = new boolean[number.length];
        solve(number,0, 0, 0, new boolean[number.length]);
        
        return answer;
    }
    
    public void solve(int[] number, int start, int sum, int cnt, boolean[] selected){
        if(cnt == 3){
            if(sum==0) answer++;
            return;
        }
        
        for(int i=start; i<number.length; i++){
                selected[i] = true;
                solve(number, i+1, sum+number[i], cnt+1, selected);
                selected[i] = false;
            
        }
    }
}
