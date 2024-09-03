import java.util.*;

class Solution {
    public long[] solution(long k, long[] room_number) {
        long[] answer = {};
        ArrayList<Long> result = new ArrayList<>();
        
        // k <= 10**12
        long left=0, right=k+1;
        HashMap<Long, Boolean> roomStatus = new HashMap<>();
        
        for (int i=0; i<room_number.length; i++) {
            if (!roomStatus.getOrDefault(room_number[i], false)) {
                roomStatus.put(room_number[i], true);
                result.add(room_number[i]);
            } else {
                left = room_number[i];
                long r = getRoomSearch(roomStatus, left, right);
                result.add(r);
            }
        }
        
        return answer;
    }
    
    /**
    * 이분탐색으로 풀어야 할 것 같아서 짰는데..
    * 어떻게 풀어야할지 모르겠다.
    */
    private long getRoomSearch(HashMap<Long, Boolean> roomStatus, long left, long right) {
        long mid = 0;
        while (left <= right) {
            mid = left + right;
        }
        return mid;
    }
}