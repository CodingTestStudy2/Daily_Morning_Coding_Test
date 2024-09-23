class Solution {
    int[] arr;
    boolean[] selected;
    int[] temp = new int[5];
    int ans = 0;
    
    public int solution(int[] nums) {
        arr = nums;
        selected = new boolean[nums.length];
        
        // n개 중에 3개 선택
        // 합이 소수가 되는지 체크
        dfs(0, 0);
        
        return ans;
    }
    
    void dfs(int idx, int cnt){
        if(cnt == 3){
            int sum = temp[0] + temp[1] + temp[2];
            if(isPrime(sum)) ans++;
            return;
        }
        
        for(int i = idx; i < arr.length; i++){
            if(!selected[i]){
                selected[i] = true;
                temp[cnt] = arr[i];
                dfs(i + 1, cnt + 1);
                selected[i] = false;
            }
        }
    }
    
    boolean isPrime(int x){
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}