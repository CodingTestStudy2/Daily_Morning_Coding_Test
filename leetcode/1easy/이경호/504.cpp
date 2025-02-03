class Solution {
public:
  string convertToBase7(int num) {
    string base;
    if (num < 0) {
      base += "-";
      num = -num;
    }
    // 몫 : q, 나머지 r;
    // 나눠야 할 대상 : num
    string temp;
    int q, r;
    if (num == 0) {
      return "0";
    }
    while (num > 0) {
      q = num / 7;
      r = num % 7;
      num = q;
      temp += to_string(r);
    }
    reverse(temp.begin(), temp.end());
    return base + temp;
  }
};