class Solution {
public:
  string generateTheString(int n) {
    string front = "a";
    string back = "b";
    string result;
    if (n % 2 == 1) {
      for (int i = 0; i < n; i++) {
        result += front;
      }
    }
    else {
      for (int i = 0; i < n - 1; i++) {
        result += front;
      }
      result += back;
    }
    return result;
  }
};