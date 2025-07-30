/**
 * @param {number} low
 * @param {number} high
 * @return {number}
 */
var countSymmetricIntegers = function(low, high) {
    let cnt = 0;
    for (let i = low; i <= high; i++) { //O(n)
        if (i.toString().length % 2 !== 0) continue; //홀수 길이의 숫자는 대칭 정수가 아님
        const mid = i.toString().length / 2 //문자열의 길이를 2로 나눈 몫 (중간 인덱스)
        const left = i.toString().substring(0, mid) //substring(start, end) : start부터 end까지의 문자열을 반환
        const right = i.toString().substring(mid, i.length) //substring(start, end) : start부터 end까지의 문자열을 반환
        const sum = str => [...str].reduce((acc, ch) => acc + Number(ch), 0); //배열의 합을 구하는 sum 함수
        //string 을 배열로 펼치고, 각 요소를 숫자로 변환해서 (Number(ch)) 누적 합을 구함 (시작 : 0)
        if (sum(left) === sum(right)) cnt += 1
    }
    return cnt
    
};