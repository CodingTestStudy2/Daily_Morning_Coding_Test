package 한준호;

class Solution {
    public int reversePairs(int[] nums) {
        long[] arr = new long[nums.length];
        for(int i = 0; i<nums.length; i++)arr[i] = nums[i];
        return merge(0, arr.length - 1, arr);
    }

    int merge(int l, int r, long[] arr){
        if(l == r) return 0;
        int mid = (l + r) / 2;
        int ans = merge(l, mid, arr) + merge(mid+1, r, arr);
        List<Long> leftList = new ArrayList<>();
        List<Long> rightList = new ArrayList<>();
        for(int i = l; i<=mid; i++){
            leftList.add(arr[i]);
        }
        for(int i = mid+1; i<=r; i++){
            rightList.add(arr[i]);
        }
        // 우측 리스트에서 하나 꺼낼 때, 좌측 리스트에서 이 수 * 2보다 큰 원소의 갯수 반환
        int lIndexForCount = 0;
        for(int i = 0; i<rightList.size(); i++){
            long now = rightList.get(i) * 2;
            while(lIndexForCount< leftList.size() && now >= leftList.get(lIndexForCount)) lIndexForCount++;
            ans += leftList.size() - lIndexForCount;
        }
        List<Long> resultList = new ArrayList<>();
        int lInd = 0;
        int rInd = 0;
        while(lInd < leftList.size() && rInd < rightList.size()){
            if(leftList.get(lInd) <= rightList.get(rInd)){
                resultList.add(leftList.get(lInd++));
            }else{
                resultList.add(rightList.get(rInd++));
            }
        }
        while(lInd < leftList.size()){
            resultList.add(leftList.get(lInd++));
        }
        while(rInd < rightList.size()){
            resultList.add(rightList.get(rInd++));
        }

        for(int i = 0; i<resultList.size(); i++){
            arr[l + i] = resultList.get(i);
        }
        return ans;
    }
    /**
     이전 배열에서 값 추출하는 방법
     매 조회마다 이분탐색
     그럼 앞 정수들이 정렬된 순서를 유지했어야 함
     세그  -> 공간복잡도 문제
     좌표압축 -> *2까지 좌표로 등록하면 되긴 함


     현재 원소에 대하여
     현재 원소 * 2 보다 큰 이전까지 등장한 모든 수를 반환
     정렬된 구조를 유지하면서, 이전까지 등장한 모든 수 찾는 법
     병합정렬 도중 연산?

     0 0 0 0 | 0 0 | 0 0
     */
}