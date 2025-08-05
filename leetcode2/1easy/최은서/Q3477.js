/**
 * @param {number[]} fruits
 * @param {number[]} baskets
 * @return {number}
 */
var numOfUnplacedFruits = function(fruits, baskets) {
    //fruits를 하나씩 baskets의 왼쪽부터 돌면서 못 넣은 과일 개수 리턴
    let res = 0;
    const n = fruits.length;
    for (let i = 0; i < n; i++) {
        let flag = false;
        for (let j = 0; j < n; j++) {
            if (fruits[i] <= baskets[j]) {
                baskets[j] = -1;
                flag = true
                break;
            }
        }
        if (!flag) {
            res += 1;
        }
    }
    return res
};