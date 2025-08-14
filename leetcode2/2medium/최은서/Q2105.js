/**
 * @param {number[]} plants
 * @param {number} capacityA
 * @param {number} capacityB
 * @return {number}
 */
var minimumRefill = function (plants, capacityA, capacityB) {
  let left = 0,
    right = plants.length - 1;
  let a = capacityA,
    b = capacityB;
  let refill = 0;
  //시간 복잡도 : O(n/2), 1 <= n <= 10^5, 투포인터
  while (left < right) {
    //리필이 필요한 경우
    if (a < plants[left]) {
      a = capacityA;
      refill += 1;
    }
    if (b < plants[right]) {
      b = capacityB;
      refill += 1;
    }
    a -= plants[left];
    b -= plants[right];
    left += 1;
    right -= 1;
  }
  if (left === right) {
    //만난 경우 -> 더 물이 많은 사람이 (리필 필요하면 리필해서) 주기
    if (a < plants[left] && b < plants[left]) {
      refill += 1;
    }
  }
  return refill;
};
