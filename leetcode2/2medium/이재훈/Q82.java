package 이재훈;

<<<<<<< HEAD
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();

        ListNode node = head;
        while (node != null) {
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            node = node.next;
        }

        ListNode tmp = new ListNode(-101);
        ListNode curr = tmp;
        while (head != null) {
            if (map.get(head.val) < 2) {
                curr.next = new ListNode(head.val);
                curr = curr.next;
            }

            head = head.next;
        }

        return tmp.next;
=======
/*
1. 아이디어 :
- 현재 cur에서 cur.next.val을 찾아가면서 처리 하기
- 같으면 넘어가고 틀리면 prev 값을 갱신

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- /
 */

public class Q82 {
    /**
     * Definition for singly-linked list.
     *
     * }
     */


    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null) return null;
            ListNode startingPoint = new ListNode(head.val, head); // dummy for head deletion

            ListNode prev = startingPoint;

            ListNode cur = head;

            while(cur != null) {
                if(cur.next != null && cur.val == cur.next.val) {
                    int val = cur.val;
                    while(cur != null && cur.val == val) {
                        cur = cur.next;
                    }

                    prev.next = cur;
                } else {
                    prev = cur;
                    cur = cur.next;
                }
            }



            return startingPoint.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    }
}