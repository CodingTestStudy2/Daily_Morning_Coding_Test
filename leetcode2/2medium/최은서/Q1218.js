/**
 * @param {number[]} arr
 * @param {number} difference
 * @return {number}
 */
var longestSubsequence = function (arr, difference) {
  const dict = {}; //dict[x] : x로 끝나는 부분 수열의 최고 길이
  let maximum = 0; //가장 긴 부분 수열의 길이
  for (let i = 0; i < arr.length; i++) {
    const x = arr[i];
    const prevLen = dict[x - difference] ?? 0;
    const currLen = Math.max(dict[x] ?? 0, prevLen + 1);
    //이전 값을 유지하거나 이어붙인 길이 중에 더 큰 값
    dict[x] = currLen; //x로 끝나는 최장 길이 갱신
    if (currLen > maximum) maximum = currLen; //전체 최댓값 갱신
  }
  return maximum;
};
