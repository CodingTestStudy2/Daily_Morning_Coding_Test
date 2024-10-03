import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int end = 0; 
        int idx = 0;
        int count = 0; 
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<int[]> running = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        while (count < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= end) {
                running.offer(jobs[idx]);
                idx++;
            }

            if (running.isEmpty()) {
                end = jobs[idx][0];
            } else {
                int[] current = running.poll();
                end += current[1];
                answer += end - current[0]; 
                count++;
            }
        }

        return answer / jobs.length;
    }
}
