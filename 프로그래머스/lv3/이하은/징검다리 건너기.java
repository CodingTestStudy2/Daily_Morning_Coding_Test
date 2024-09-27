import java.util.*;

/*
디딤돌의 숫자는 한 번 밟을 때마다 1씩 줄어듭니다.

디딤돌의 숫자가 0이 되면 더 이상 밟을 수 없으며 
이때는 그 다음 디딤돌로 한번에 여러 칸을 건너 뛸 수 있습니다.
단, 한 번에 건너뛸 수 있는 디딤돌의 최대 칸수 k로 제한 

다음으로 밟을 수 있는 디딤돌이 여러 개인 경우 
무조건 "가장 가까운" 디딤돌로만 건너뛸 수 있습니다.

-> 최대 몇 명까지 징검다리를 건널 수 있는가? 
-> 니니즈 친구가 x명일 때, 전부 stones 배열의 끝까지 건널 수 있는가?
-> TRUE: x명 늘리기 (true 구간의 최댓값)
-> FALSE: x명 줄이기
*/
class Solution {
    public int solution(int[] stones, int k) {
        int maxNum = 0;
        for(int num: stones){ // 최대 20만 
            maxNum = Math.max(maxNum, num);
        }
        
        int left = 0, right = maxNum; // 최대 2억 
        int ans = 0;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(decision(stones, mid, k)){
                ans = Math.max(ans, mid);
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        return ans;
    }
    
    // 니니즈 친구가 x명일 때 
    // 연속된 0의 개수 < k 
    boolean decision(int[] stones, int x, int k){        
        int cnt = 0;
        
        for(int i = 0; i < stones.length; i++){
            if(stones[i] < x) cnt++;
            else cnt = 0;
            
            if(cnt >= k) return false;
        }
        
        return true;
    }
}