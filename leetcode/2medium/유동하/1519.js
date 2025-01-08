/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {string} labels
 * @return {number[]}
 */
var countSubTrees = function (n, edges, labels) {
  const tree = new Array(n);
  const result = new Array(n).fill(0);
  const labelList = labels.split("");

  for (let i = 0; i < n; i++) {
    tree[i] = new Array();
  }

  for (const edge of edges) {
    tree[edge[0]].push(edge[1]);
    tree[edge[1]].push(edge[0]);
  }

  const dfs = (node, parent) => {
    const map = {};

    for (const child of tree[node]) {
      if (child === parent) continue;
      const data = dfs(child, node);

      for (const [label, cnt] of Object.entries(data)) {
        if (!map[label]) map[label] = 0;
        map[label] += cnt;
      }
    }

    if (!map[labelList[node]]) map[labelList[node]] = 0;
    map[labelList[node]]++;
    result[node] = map[labelList[node]];

    return map;
  };

  dfs(0);

  return result;
};
