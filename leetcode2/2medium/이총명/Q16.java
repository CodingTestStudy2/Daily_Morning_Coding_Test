class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);  // 배열 정렬
        int closest = nums[0] + nums[1] + nums[2];  // 초기값 설정

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            // left가 right 보다 작을 때까지 반복
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // 현재 합이 기존의 가장 가까운 값보다 더 target에 가까우면 갱신
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }

                // 세 수의 합이 target 보다 작으면 더 큰 수를 만들기 위해 left 증가
                if (sum < target) {
                    left++;
                // 세 수의 합이 target 보다 크면 더 작은 수를 만들기 위해 right 감소
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;  // target과 정확히 같으면 바로 리턴
                }
            }
        }

        return closest;
    }
}
/*
1. 타겟넘버 찾기
2. 
3. 
4. 
5. 
*/
