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
    class Node {
        int index;
        Node prev;
        Node next;

        Node(int index) {
            this.index = index;
        }
    }

    Stack<Node> stack = new Stack<>();
    Node[] nodes;

    public void init(int n) {
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
            if (i > 0) {
                nodes[i].prev = nodes[i - 1];
                nodes[i - 1].next = nodes[i];
            }
        }
    }

    public Node moveUp(Node curr, int count) {
        while (count > 0 && curr.prev != null) {
            curr = curr.prev;
            count--;
        }
        return curr;
    }

    public Node moveDown(Node curr, int count) {
        while (count > 0 && curr.next != null) {
            curr = curr.next;
            count--;
        }
        return curr;
    }

    public Node remove(Node curr) {
        stack.push(curr);

        if (curr.prev != null) {
            curr.prev.next = curr.next;
        }
        if (curr.next != null) {
            curr.next.prev = curr.prev;
        }

        return (curr.next != null) ? curr.next : curr.prev;
    }

    public void restore() {
        if (!stack.isEmpty()) {
            Node restored = stack.pop();

            if (restored.prev != null) {
                restored.prev.next = restored;
            }
            if (restored.next != null) {
                restored.next.prev = restored;
            }
        }
    }


    public String solution(int n, int k, String[] cmd) {
        init(n);
        Node curr = nodes[k];

        for (String command : cmd) {
            String[] parts = command.split(" ");
            char op = parts[0].charAt(0);

            if (op == 'U') {
                curr = moveUp(curr, Integer.parseInt(parts[1]));
            } else if (op == 'D') {
                curr = moveDown(curr, Integer.parseInt(parts[1]));
            } else if (op == 'C') {
                curr = remove(curr);
            } else if (op == 'Z') {
                restore();
            }
        }

        StringBuilder sb = new StringBuilder("O".repeat(n));
        while (!stack.isEmpty()) {
            Node deletedNode = stack.pop();
            sb.setCharAt(deletedNode.index, 'X');
        }

        return sb.toString();
    }
}


'''


