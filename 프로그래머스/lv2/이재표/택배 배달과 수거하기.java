import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<int[]> delieveryStack = new Stack<>();
        Stack<int[]> pickupStack = new Stack<>();
        for (int i = 0; i < deliveries.length; i++) {
            if(deliveries[i] != 0) {
                delieveryStack.push(new int[]{i, deliveries[i]});
            }
            if(pickups[i] != 0) {
                pickupStack.push(new int[]{i, pickups[i]});
            }
        }
        while (!delieveryStack.isEmpty() || !pickupStack.isEmpty()) {
            int pos = 0;
            int stock = cap;
            while (!delieveryStack.isEmpty()) {
                int[] d = delieveryStack.pop();
                int delievery = d[1];
                if (pos < d[0]) {
                    pos = d[0];
                }
                if (stock < delievery) {
                    delieveryStack.push(new int[]{d[0], delievery - stock});
                    break;
                }
                stock -= d[1];
            }
            stock = cap;
            while (!pickupStack.isEmpty()) {
                int[] p = pickupStack.pop();
                int pickup = p[1];
                if (pos < p[0]) {
                    pos = p[0];
                }
                if (stock < pickup) {
                    pickupStack.push(new int[]{p[0], pickup - stock});
                    break;
                }
                stock -= p[1];
            }
            answer += (pos+1) * 2;
        }
        return answer;
    }
}
