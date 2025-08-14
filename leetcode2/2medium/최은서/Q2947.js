/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var beautifulSubstrings = function (s, k) {
  const vowels = new Set("aeiou");
  const n = s.length;
  let res = 0;
  //시간 복잡도 O(n^2), 1 <= n <= 10^3
  //풀이
  //[1] substring 의 시작점 i ~ 끝점 j 에서 모음, 자음의 개수를 매 번 카운트
  //[2] 조건에 맞게 (모음 * 자음)이 k의 배수인지 확인
  for (let i = 0; i < n; i++) {
    let v = 0,
      c = 0;
    for (let j = i; j < n; j++) {
      if (vowels.has(s[j])) v += 1;
      else c += 1;
      if (v === c) {
        let x = v * c;
        if (x % k === 0) res += 1;
      }
    }
  }
  return res;
};
