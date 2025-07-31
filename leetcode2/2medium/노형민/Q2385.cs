using System;
using System.Collections;

//public class TreeNode
//{
//    public int val;
//    public TreeNode left;
//    public TreeNode right;

//    public TreeNode(int val = 0, TreeNode left = null, TreeNode right = null)
//    {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}

public class Solution
{
    // 주어진 노드에서 가장 거리가 먼 노드를 찾는 문제
    public int AmountOfTime(TreeNode root, int start)
    {
        Queue<TreeNode> nodeQueue = new();
        Dictionary<int, int[]> graph = new();
        int result = 0;

        TreeNode startNode = root;
        nodeQueue.Enqueue(startNode);
        while (nodeQueue.Count != 0)
        {
            TreeNode currentNode = nodeQueue.Dequeue();

            if (!graph.ContainsKey(currentNode.val))
            {
                graph[currentNode.val] = new int[3];
            }

            if (currentNode.left != null)
            {
                nodeQueue.Enqueue(currentNode.left);
                if (!graph.ContainsKey(currentNode.val))
                {
                    graph[currentNode.val] = new int[3];
                }
                graph[currentNode.val][0] = currentNode.left.val;

                if (!graph.ContainsKey(currentNode.left.val))
                {
                    graph[currentNode.left.val] = new int[3];
                }
                graph[currentNode.left.val][2] = currentNode.val;
            }

            if (currentNode.right != null)
            {
                nodeQueue.Enqueue(currentNode.right);
                if (!graph.ContainsKey(currentNode.val))
                {
                    graph[currentNode.val] = new int[3];
                }
                graph[currentNode.val][1] = currentNode.right.val;

                if (!graph.ContainsKey(currentNode.right.val))
                {
                    graph[currentNode.right.val] = new int[3];
                }
                graph[currentNode.right.val][2] = currentNode.val;
            }
        }

        Queue<int> graphQueue = new();

        HashSet<int> visited = new();
        graphQueue.Enqueue(start);
        visited.Add(start);

        while (graphQueue.Count != 0)
        {
            int size = graphQueue.Count;
            for (int i = 0; i < size; i++)
            {
                int currentNode = graphQueue.Dequeue();
                foreach (int neighbor in graph[currentNode])
                {
                    if (neighbor == 0)
                    { 
                        continue;
                    }

                    if (!visited.Contains(neighbor))
                    {
                        visited.Add(neighbor);
                        graphQueue.Enqueue(neighbor);
                    }
                }
            }
            result++;
        }

        //자기 자신도 길이에 포함됨
        return result - 1;
    }
}