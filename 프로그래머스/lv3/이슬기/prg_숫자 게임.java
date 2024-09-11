/**
* 이진탐색
2 3 4 5 -> 오름차순
3 5

1 3 5 7
2 6 8
*/
import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int n = A.length;
        
        Arrays.sort(A);
        Arrays.sort(B);
        List<Integer> arr = new ArrayList<>(Arrays.asList(Arrays.stream(B).boxed().toArray(Integer[]::new)));
        
        for (int i=0; i<n; i++) {
            int left = 0, right = arr.size()-1, mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (arr.get(mid) <= A[i]) {
                    left = mid + 1;
                } else if (arr.get(mid) > A[i]) {
                    right = mid - 1;
                }
            }
            
            if (arr.get(mid) > A[i]) {
                answer ++;
            } else {
                if (mid+1 < arr.size() && arr.get(mid+1) > A[i]) {
                    mid ++;
                    answer ++;
                }
            }
            
            //System.out.println(arr.get(mid));
            arr.remove(mid);
            //System.out.println(arr.toString());
        }
        
        return answer;
    }
}