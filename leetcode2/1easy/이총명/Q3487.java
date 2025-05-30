// 실패

class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        int answer = 0;
        boolean allMinus = true;
        int max = Integer.MIN_VALUE;
        // 모든 집합이 마이너스 인가?
        for(int num : nums){
            // 양수가 나오면 break;
            if(num > 0){
                allMinus = false;
                break;
            }
        }
        // 모든 집합이 마이너스
        if(allMinus = true){
            for(int num : nums){
                if(num > max)
                max = num;
            }
            answer = max;
            return answer;
        }
        // 집합에 양수가 하나라도 있음
        else if(allMinus = false){
            for(int i = 0; i < nums.length; i++){
                if(nums[i] > 0)
                hash.add(nums[i]);
            }
            for(int num : hash){
                answer+=num;
            }
        }
        return answer;
    }
}
