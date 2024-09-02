# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


from collections import defaultdict
import heapq
def solution(operations):
    def remove_minheap():
        while minheap and counter[minheap[0]]==0:
            heapq.heappop(minheap)
    def remove_maxheap():
        while maxheap and counter[-maxheap[0]] == 0:
            heapq.heappop(maxheap)

    minheap = []
    maxheap = []
    counter = defaultdict(int)

    for op in operations:
        op = op.split(" ")
        cmd, val = op[0], int(op[1])

        if cmd == "I":
            counter[val]+=1
            heapq.heappush(minheap, val)
            heapq.heappush(maxheap, -val)

        elif cmd == "D":
            if val == -1:
                remove_minheap()
                if not minheap: continue
                num = heapq.heappop(minheap)
                counter[num]-=1

            elif val == 1:
                remove_maxheap()
                if not maxheap: continue
                num = -heapq.heappop(maxheap)
                counter[num]-=1

    remove_minheap()
    remove_maxheap()

    if not minheap or not maxheap:
        return [0,0]
    return [-maxheap[0], minheap[0]]


'''
import java.util.*;

class Solution {
    void removeNumber(PriorityQueue<Integer> heap, Map<Integer, Integer> countMap){
        while (!heap.isEmpty() && countMap.getOrDefault(heap.peek(), 0) == 0){
            heap.poll();
        }
    }
    
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (String operation: operations){
            String[] opStr = operation.split(" ");
            char cmd = opStr[0].charAt(0);
            int val = Integer.parseInt(opStr[1]);
            
            if (cmd == 'I'){
                countMap.put(val, countMap.getOrDefault(val, 0)+1);
                maxHeap.offer(val);
                minHeap.offer(val);
            } else if (cmd == 'D'){
                if (val == -1){
                    if (!minHeap.isEmpty()) {
                        int min = minHeap.poll();
                        countMap.put(min, countMap.getOrDefault(min, 0)-1);
                        removeNumber(minHeap, countMap);
                    }
                } else if (val == 1) {
                    if (!maxHeap.isEmpty()) {
                        int max = maxHeap.poll();
                        countMap.put(max, countMap.getOrDefault(max, 0)-1);
                        removeNumber(minHeap, countMap);
                    }
                }
            }
        }
        removeNumber(minHeap, countMap);
        removeNumber(maxHeap, countMap);
        
        if (minHeap.isEmpty() || maxHeap.isEmpty()) {
            return new int[]{0,0};
        } else {
            return new int[]{maxHeap.peek(), minHeap.peek()};
        }
    }
}
'''