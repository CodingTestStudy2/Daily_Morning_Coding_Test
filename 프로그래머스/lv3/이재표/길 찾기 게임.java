import java.util.*;
class Solution {
    class Node {
        int x;
        Node left;
        Node right;
        int idx;
        public Node(int x, Node left, Node right,int idx) {
            this.x = x;
            this.left = left;
            this.right = right;
            this.idx=idx;
        }
    }
    int[][] result;
    public int[][] solution(int[][] nodeinfo) {
        result = new int[2][nodeinfo.length];
        Map<Integer, List<Node>> map = new HashMap<>();
        
        for (int i = 0; i < nodeinfo.length; i++) {
            int y = nodeinfo[i][1];
            map.putIfAbsent(y, new ArrayList<>());
            map.get(y).add(new Node(nodeinfo[i][0], null, null,i+1));
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, Collections.reverseOrder());

        int first = list.get(0);
        Node root = map.get(first).get(0);

        for (int i = 1; i < list.size(); i++) {
            List<Node> nodes = map.get(list.get(i));
            for (Node n : nodes) {
                insertNode(root, n);
            }
        }
        
        pre(root);
        index=0;
        post(root);
        
        return result;
    }
    int index=0;
    private void insertNode(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }
    public void pre(Node current) {
        result[0][index++] = current.idx;
        if (current.left != null) {
            pre(current.left);
        }
        if (current.right != null) {
            pre(current.right);
        }
    }

    public void post(Node current) {
        if (current.left != null) {
            post(current.left);
        }
        if (current.right != null) {
            post(current.right);
        }
        result[1][index++] = current.idx;
    }
}
