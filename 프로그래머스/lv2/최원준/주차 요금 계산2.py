# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :


import java.util.*;
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    Map<String, Integer> totalTime = new HashMap<>();
    Map<String, Integer> history = new HashMap<>();
    Set<String> parked = new HashSet<>();

    public int getCost(int totalTime, int[] fees) {
        return totalTime <= fees[0]? fees[1] : fees[1] + (int)Math.ceil((float)(totalTime - fees[0]) / fees[2]) * fees[3];
    }

    public int serialize(String time) {
        String[] hm = time.split(":");
        return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
    }

    public int[] solution(int[] fees, String[] records) {
        for (String record : records) {
            String[] info = record.split(" ");
            int time = serialize(info[0]);
            String carNum = info[1];

            if (info[2].equals("IN")) {
                history.put(carNum, time);
                parked.add(carNum);
            } else {
                int duration = time - history.get(carNum) ;
                totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + duration);
                parked.remove(carNum);
            }
        }

        for (String carNum : parked) {
            int duration = serialize("23:59") - history.get(carNum);
            totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + duration);
        }

        ArrayList<int[]> sortList = new ArrayList<>();
        for (var entry : totalTime.entrySet()){
            sortList.add(new int[]{Integer.parseInt(entry.getKey()),getCost(entry.getValue(), fees)});
        }
        sortList.sort((a,b) -> a[0]-b[0]);
        int[] ans = new int[sortList.size()];
        for (int i=0; i<ans.length; i++) ans[i] = sortList.get(i)[1];

        return ans;
    }
}
'''


