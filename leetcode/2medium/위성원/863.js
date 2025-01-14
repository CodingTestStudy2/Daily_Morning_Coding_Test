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

  const nodes = [];
  const q = [];
  q[0] = root;
  while (q.length > 0) {
    const node = q.shift();
    nodes.push(node);
    if (!node) {
      continue
    }

    if (node.left) {
      q.push(node.left)
    } else {
      q.push(null)
    }

    if (node.right) {
      q.push(node.right)
    } else {
      q.push(null)
    }
  }

  const values = [];
  console.log(nodes)

  const visited = new Array(500).fill(false)
  const getParentNode = (node) => {
    const nodeIndex = nodes.findIndex((n) => !!n && n.val === node.val)

    if (nodeIndex === -1) {
      return null;
    }

    const parentIndex = Math.floor((nodeIndex - 1) / 2)
    console.log({ parentIndex })

    return nodes[parentIndex]
  }

  const go = (node, dis) => {
    console.log(node, dis, ": current")
    if (visited[node.val]) {
      return;
    }


    visited[node.val] = true
    if (dis > k) {
      return
    }

    if (dis === k) {
      console.log(node, dis)
      values.push(node.val)
      return
    }

    if (node.left) {
      go(node.left, dis + 1)
    }

    if (node.right) {
      go(node.right, dis + 1)
    }

    const parentNode = getParentNode(node)
    if (parentNode) {
      console.log(node, " in ")
      go(parentNode, dis + 1)
    }
  }

  go(target, 0)

  return values
};