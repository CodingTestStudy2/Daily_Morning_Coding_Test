/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {string} labels
 * @return {number[]}
 */
var countSubTrees = function (n, edges, labels) {
  const ans = [];
  const nodes = [];
  for (let i = 0; i < edges.length; i++) {
    const [a, b] = edges[i];
    const node = nodes[a];
    if (!node) {
      nodes[a] = [b];
    } else {
      nodes[a] = [...node, b];
    }
  }

  const check = (cn, alpa, count) => {
    if (labels[cn] !== labels[alpa]) {
      const cc = ans[alpa] ?? 1;
      if (count > cc) {
        ans[alpa] = count;
      }
      return;
    }

    count++;

    console.log({ count, nodes, alpa, cn });
    const node = nodes[cn];

    if (!node) {
      const cc = ans[alpa] ?? 1;
      if (count > cc) {
        ans[alpa] = count;
      }
      return;
    }

    for (let j = 0; j < node.length; j++) {
      const newCn = node[j];
      check(newCn, j, count + 1);
    }

    const cc = ans[alpa] ?? 1;
    if (count > cc) {
      ans[alpa] = count;
    }
  };

  for (let i = 0; i < nodes.length; i++) {
    const node = nodes[i];
    for (let j = 0; j < node.length; j++) {
      const currentNode = node[j];
      check(currentNode, i, 1);
    }
  }

  if (ans.length !== n) {
    for (let i = ans.length; i < n; i++) {
      ans.push(1);
    }
  }

  return ans;
};
