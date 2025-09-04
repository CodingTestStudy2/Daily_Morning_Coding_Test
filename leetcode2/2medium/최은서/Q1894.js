/**
 * @param {number[]} chalk
 * @param {number} k
 * @return {number}
 */
//처음 방식 : 문제에 나와있는대로 분필 없을 때까지 각각 분필 사용하는 방식으로
//문제 : 1 <= k <= 10^9 제약조건으로 [1, 1, ...] k = 999999999 일 때 시간 초과 발생
var chalkReplacer = function (chalk, k) {
  const n = chalk.length;
  const tot = chalk.reduce((cur, acc) => cur + acc, 0);
  let remaining = k % tot; //X회 분필 사용하는 횟수를 돌리고나서 마지막 바퀴에 남은 분필 수
  if (remaining === 0) return 0; //없는 경우에는 바로 종료
  for (let i = 0; i < n; i++) {
    //남은 경우에는 한 명씩 분필 사용하며 순회
    remaining -= chalk[i];
    if (remaining < 0) {
      return i;
    } else if (remaining === 0) {
      return i + 1;
    }
  }
};
