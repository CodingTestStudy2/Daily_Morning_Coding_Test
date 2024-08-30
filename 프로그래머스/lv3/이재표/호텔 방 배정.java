import java.util.*;
class Solution {
    Map<Long, Long> map = new HashMap<>(); 

    public long[] solution(long k, long[] room_number) {
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < room_number.length; i++) {
            long room = getRoomNum(room_number[i]);
            list.add(room);
        }

        long[] answer = new long[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public long getRoomNum(long roomN) { 
        if (!map.containsKey(roomN)) { 
            map.put(roomN, roomN + 1);
            return roomN;
        }
        long nextRoom = getRoomNum(map.get(roomN));
        map.put(roomN, nextRoom); 
        return nextRoom;
    }
}
