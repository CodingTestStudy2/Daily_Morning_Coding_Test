/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {string} traversal
 * @return {TreeNode}
 */

var recoverFromPreorder = function(traversal) {
    //1. 트리의 깊이를 나타내는 문자열을 파싱하여 각 노드의 값과 깊이를 추출
    let i = 0;
    const treeDepth = []
    while (i < traversal.length) {
        //트리 깊이 계산하기
        let dep = 0; 
        while (traversal[i] === '-') {
            dep += 1;
            i += 1;
        }
        //노드 값 추출하기
        let num = 0;
        while (i < traversal.length && traversal[i] !== '-') {
            num = num * 10 + Number(traversal[i]);
            i += 1;
        } // 한 자리수 이상을 고려하여 num을 10으로 곱하고 현재 숫자를 더함
        treeDepth.push([num, dep])
    }
    //treeDepth는 [노드 값, 깊이] 형태의 배열로 구성됨 (ex. 1-2--3--4-5--6--7 -> [[1, 0], [2, 1], [3, 2], [4, 2], [5, 1], [6, 2], [7, 2]])
    //2. 스택을 이용해서 트리 재구성하기
    const stack = [];
    for (const [val, depth] of treeDepth) {
        const node = new TreeNode(val);
        if (depth > 0) { //현재 노드의 깊이가 0이 아니면, 스택에서 부모 노드를 찾아서 연결
            const parent = stack[depth-1]; //스택에서 현재 깊이보다 하나 작은 깊이의 노드를 부모로 설정
            if (!parent.left) {
                parent.left = node;
            }
            else {
                parent.right = node;
            }
        }
        stack[depth] = node;
    }
    return stack[0]
};