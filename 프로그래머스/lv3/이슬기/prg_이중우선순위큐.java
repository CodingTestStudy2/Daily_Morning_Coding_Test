/**
* 이중 우선순위 큐
* 1. 최솟값 삭제 -> Priority Queue로 구현 가능
* 2. 최댓값 삭제 -> 최대힙 사용해야함.
*
* 모든 원소를 모아두는 ArrayList를 활용하여 최댓값, 최솟값 삭제
*/
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparingInt(x -> -x));
        ArrayList<Integer> element = new ArrayList<>();
        
        for (int i=0; i<operations.length; i++) {
            String[] operate = operations[i].split(" ");
            if (operate[0].equals("I")) {
                minHeap.offer(Integer.parseInt(operate[1]));
                maxHeap.offer(Integer.parseInt(operate[1]));
                element.add(Integer.parseInt(operate[1]));
            } else if (operate[0].equals("D") && operate[1].equals("1") && !element.isEmpty()) {
                while (!element.contains(maxHeap.peek())) {
                    maxHeap.poll();
                }
                element.remove(maxHeap.poll());
            } else if (operate[0].equals("D") && operate[1].equals("-1") && !element.isEmpty()) {
                while (!element.contains(minHeap.peek())) {
                    minHeap.poll();
                }
                element.remove(minHeap.poll());
            }
        }
        Collections.sort(element, Collections.reverseOrder());
        //System.out.println(element.toString());
        if (!element.isEmpty()) {
            answer = new int[]{element.get(0), element.get(element.size()-1)};
        }
        
        return answer;
    }
}