/*
// Definition for a Node.
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
*/

class Solution {

    static Map<Integer, Queue<Node>> map;

    public Node connect(Node root) {
        map = new HashMap<>();
        searchDepth(0, root);
        return helper(0, root);
    }

    private Node helper(int depth, Node root) {
        if (root == null) return null;
        if (!map.get(depth).isEmpty()) {
            Node n = map.get(depth).poll();
            root.next = n;
        }

        helper(depth + 1, root.left);
        helper(depth + 1, root.right);

        return root;
    }

    private void searchDepth(int depth, Node root) {
        if (root == null) return;

        if (!map.containsKey(depth)) {
            map.put(depth, new ArrayDeque<>());
        } else {
            map.get(depth).add(root);
        }

        searchDepth(depth + 1, root.left);
        searchDepth(depth + 1, root.right);
    }
}