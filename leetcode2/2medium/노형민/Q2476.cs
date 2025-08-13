/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution
{
    public IList<IList<int>> ClosestNodes(TreeNode root, IList<int> queries)
    {
        List<int> sortedValues = [];
        InOrderTraversal(root, sortedValues);

        List<IList<int>> result = [];

        for (int i = 0; i < queries.Count; i++)
        {
            result.Add(FindClosestNodes(sortedValues, queries[i]));
        }

        return result;
    }

    private IList<int> FindClosestNodes(List<int> sortedValues, int query)
    {
        int left = 0, right = sortedValues.Count - 1;
        int closestLessThan = -1, closestGreaterThan = -1;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (sortedValues[mid] < query)
            {
                closestLessThan = sortedValues[mid];
                left = mid + 1;
            }
            else if (sortedValues[mid] > query)
            {
                closestGreaterThan = sortedValues[mid];
                right = mid - 1;
            }
            else
            {
                return new List<int> { sortedValues[mid], sortedValues[mid] };
            }
        }
        return [closestLessThan, closestGreaterThan];
    }

    private void InOrderTraversal(TreeNode node, List<int> values)
    {
        if (node == null)
        {
            return;
        }
        InOrderTraversal(node.left, values);
        values.Add(node.val);
        InOrderTraversal(node.right, values);
    }
}