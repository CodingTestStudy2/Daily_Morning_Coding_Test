class LC_2784 {
    public boolean isGood(int[] nums) {
        int maxNum = 0;
        for(int i=0; i<nums.length; i++){
            maxNum = Math.max(maxNum, nums[i]);
        }

        int visited[] = new int[maxNum+1];
        for(int i=0; i<nums.length; i++){
            visited[nums[i]] += 1;
        }
        
        for (int i = 1; i <= maxNum; i++) {
            if(i == maxNum && visited[i] != 2){
                return false;
            }
            if(i != maxNum && visited[i] != 1){
                return false;
            }
        }

        return true;
    }
}