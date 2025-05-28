class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        // 1. 각 piece의 첫번째 숫자를 key로, 전체 piece를 values로 매핑
        Map <Integer, int[]> map = new HashMap<>();
        for(int i = 0; i < pieces.length; i++){
            map.put(pieces[i][0], pieces[i]);
        }

        int i = 0;
        while(i < arr.length){
            // 2.현재 arr[i]가 어떤 조각의 첫 숫자인지 확인
            if (!map.containsKey(arr[i])){
                return false;
            }

            int[] piece = map.get(arr[i]);
            // 3.조각의 숫자들과 arr를 한 칸씩 비교
            for(int num : piece) {
                // piece 가 arr의 길이 보다 길거나 arr[i]가 num 과 다를 때
                if(i >= arr.length || arr[i] != num){
                    return false;
                }
                i++;
            }
        }
        return true;
        
    }
}
