/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} target
 * @param {number} k
 * @return {number[]}
 */
var distanceK = function (root, target, k) {
  const result = [];

  const findTarget = (node, parent) => {
    if (!node) return;
    node.parent = parent;
    if (node === target) return node;
    return findTarget(node.left, node) || findTarget(node.right, node);
  };

  const findResult = (node, k) => {
    if (!node || node.visit) return;

    if (k === 0) {
      result.push(node.val);
      return;
    }

    node.visit = true;

    findResult(node.left, k - 1);
    findResult(node.right, k - 1);
    findResult(node.parent, k - 1);
  };

  const node = findTarget(root, null);
  findResult(node, k);

  return result;
};
