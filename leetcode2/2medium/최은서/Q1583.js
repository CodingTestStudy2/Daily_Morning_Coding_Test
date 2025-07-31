/**
 * @param {number} n
 * @param {number[][]} preferences
 * @param {number[][]} pairs
 * @return {number}
 */
var unhappyFriends = function(n, preferences, pairs) {
    const matrix = Array.from({length : n}, () => Array(n).fill(0));
    let cnt = 0;
    for (let i = 0; i<n; i++) {
        for (let j = 0; j < n-1 ; j++) { //preferences
            matrix[i][preferences[i][j]] = n-j-1
        }
    } //O(n^2)
    console.log(matrix)
    const partner = new Array(n);
    for (const [a, b] of pairs) {
        partner[a] = b;
        partner[b] = a;
    }
    for (let x = 0; x < n; x++) {
        for (let u = 0; u < n; u++) {
            const y = partner[x]
            const v = partner[u]
            if (x === u && u === partner[x]) continue //u가 자기 자신이거나 파트너면 건너뛰기
            if (matrix[x][u] > matrix[x][y] && matrix[u][x] > matrix[u][v]) {
                cnt += 1;
                break;
            }
        }
    }
    return cnt;
};