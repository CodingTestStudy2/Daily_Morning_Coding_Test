/**
 * @param {number} n
 * @param {number} headID
 * @param {number[]} manager
 * @param {number[]} informTime
 * @return {number}
 */
var numOfMinutes = function(n, headID, manager, informTime) {
    const tree = new Map();
    for (let i = 0; i < n; i++) {
        if (!tree.has(manager[i])) tree.set(manager[i], [])
        tree.get(manager[i]).push(i)
    }
    // 2 -> [0, 1, 3, 4, 5], -1 -> [2]
    const queue = [[headID, 0]]
    let maxTime = 0;
    while (queue.length) {
        const [id, time] = queue.shift();
        maxTime = Math.max(maxTime, time)
        if (tree.get(id)) {
            for (const nxt of tree.get(id)) {
                queue.push([nxt, time + informTime[id]])
            }
        }
    }
    return maxTime;
};