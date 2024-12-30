var isGood = function (nums) {
  let len = nums.length;
  nums.sort((a, b) => a - b);
  if (nums[len - 1] !== nums[len - 2]) return false;
  for (let i = 0; i < nums.length - 1; i++) {
    if (nums[i] != i + 1) return false;
  }
  return true;
};

//처음 생각한 방법 : max 값을 찾고 그 값을 제외한 애들은 한개이고 그 값은 두개인지 확인하기
//두번 째 방법 : 배열을 정렬한 후 맨 뒤에 있는 값을 두 번 나오는지, 나머지 값들은 한 번씩 나오는지 확인하기
