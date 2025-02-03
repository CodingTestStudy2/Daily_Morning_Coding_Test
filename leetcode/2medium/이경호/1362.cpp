class Solution {
public:
  vector<int> closestDivisors(int num) {
    int num1 = num + 1;
    int num2 = num + 2;
    vector<int> num1s;
    vector<int> num2s;
    for (int i = ceil(sqrt(num1)); i > 0; i--) {
      if (num1 % i == 0) {
        num1s.push_back(num1 / i);
        num1s.push_back(i);
        break;
      }
    }
    for (int i = ceil(sqrt(num2)); i > 0; i--) {
      if (num2 % i == 0) {
        num2s.push_back(num2 / i);
        num2s.push_back(i);
        break;
      }
    }
    if (num1s[0] - num1s[1] < num2s[0] - num2s[1]) {
      return num1s;
    }
    else {
      return num2s;
    }
  }
};