function countKConstraintSubstrings(s, k) {
  let count0 = 0;
  let count1 = 0;
  let left = 0;
  let result = 0;

  for (let right = 0; right < s.length; right++) {
    if (s[right] === "0") {
      count0++;
    } else {
      count1++;
    }

    while (count0 > k && count1 > k) {
      if (s[left] === "0") {
        count0--;
      } else {
        count1--;
      }
      left++;
    }

    result += right - left + 1;
  }

  return result;
}
