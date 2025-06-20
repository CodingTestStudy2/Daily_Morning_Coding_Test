class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        // 1. nums2를 순회하며 다음 큰 수를 찾는다
        for(int num : nums2) {
            while(!stack.isEmpty() && stack.peek() < num){
                int smaller = stack.pop();
                nextGreaterMap.put(smaller, num);
            }
            stack.push(num);
        }
        // 2. 스택에 남은 값은 다음 큰 수가 없음
        while(!stack.isEmpty()){
            nextGreaterMap.put(stack.pop(), -1);
        }

        // 3. nums1의 값에 해당하는 다음 큰 수를 맵에서 꺼낸다.
        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            result[i] = nextGreaterMap.get(nums1[i]);
        }

        return result;
    }
}
