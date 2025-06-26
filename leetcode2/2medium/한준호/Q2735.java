package 한준호;

class Solution {
    public long minCost(int[] nums, int x) {
        long ans = Long.MAX_VALUE;
        int[] minimum = new int[nums.length];
        for(int i = 0; i<nums.length; i++) minimum[i] = nums[i];
        for (int operation = 0; operation < nums.length; operation++) {
            long cost = (long) operation * x;
            for(int i = 0; i<nums.length; i++){
                minimum[i] = Math.min(minimum[i], nums[(i + operation)%nums.length]);
                cost+=minimum[i];
            }
            ans = Math.min(ans, cost);
        }
        return ans;
    }
    // 몇번 돌리냐를 고정해두고 나면, 그 중 최솟값을 사용할 수 있다.
    // 몇번 돌리는지 결정
    // 반복문 순회
    // 현재 인덱스의 최소
    // x 가 고정적으로 늘어난다는 점을 이용할수는 없나?
    // nums[i] + x +(tx) < nums[i+1] + (tx)
    // nums[i+1] = nums[i] + x
    // 근데 x가 가변인데 (몇번 돌다 온건지 모름)
    // 이전의 상태의 저장 방법이 있나
    // 결국 해당 x의 최솟값은 내 뒤 몇번째 칸에 있느냐로 결정됨
    // 몇번 돌리는지 결정 - operation
    // 해당 지점 넣었을 때 값 갱신 - 해당 인덱스의 새 값 계산 -> 이때 x값 넣어주지 않기?
    // 어차피 해당 수 쓸 수 있으면 쓰는게 나음 -> operation 만큼 비용 x를 이미 지불했기 때문에
    // 해당 값은 배열 전체의 순회 횟수에 부과되는 비용
    // 단계별로 갱신해가며 값 계산
}