package 이재훈;

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
    }
}