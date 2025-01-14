import java.util.*;

import java.util.*;

class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 1. 트리에서 부모-자식 관계를 기록
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap);

        // 2. BFS를 사용해 거리 k에 있는 노드 찾기
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);

        int currentDistance = 0;
        while (!queue.isEmpty()) {
            if (currentDistance == k) {
                List<Integer> result = new ArrayList<>();
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return result;
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null && !visited.contains(node.left)) {
                    queue.add(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    queue.add(node.right);
                    visited.add(node.right);
                }
                if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                    queue.add(parentMap.get(node));
                    visited.add(parentMap.get(node));
                }
            }

            currentDistance++;
        }
        return new ArrayList<>();
    }

    private void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) return;
        if (parent != null) {
            parentMap.put(node, parent);
        }
        buildParentMap(node.left, node, parentMap);
        buildParentMap(node.right, node, parentMap);
    }
}
