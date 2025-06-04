package 이재훈;

/*
1. 아이디어 :
- root 부터 왼쪽에서 오른쪽으로 돌면서 자식들의 노드들을 하나씩 이어준다.



2. 시간복잡도 :
O( n)
3. 자료구조/알고리즘 :
- /
 */

public class Q117 {


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


    class Solution {
        public Node connect(Node root) {

            Node entryNode = root;

            while(entryNode != null) {
                Node cur = entryNode;
                Node head = null;
                Node tail = null;

                while(cur != null) {
                    // left
                    if(cur.left != null) {
                        if(head == null) {
                            head = cur.left;
                            tail = cur.left;
                        } else {
                            tail.next = cur.left;
                            tail = tail.next;
                        }
                    }
                    // right
                    if(cur.right != null) {
                        if(head == null) {
                            head = cur.right;
                            tail = cur.right;
                        } else {
                            tail.next = cur.right;
                            tail = tail.next;
                        }
                    }

                    cur = cur.next;
                }

                entryNode = head;
            }
            return root;
        }

    }
}
