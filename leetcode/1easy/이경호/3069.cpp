class Solution {
public:
  vector<int> resultArray(vector<int>& nums) {
    vector<int> arr1, arr2, result;
    queue<int> q(nums.begin(), nums.end());
    arr1.push_back(q.front());
    q.pop();
    arr2.push_back(q.front());
    q.pop();
    while (q.size()) {
      if (arr1.back() > arr2.back()) {
        arr1.push_back(q.front());
        q.pop();
      }
      else {
        arr2.push_back(q.front());
        q.pop();
      }
    }
    result.insert(result.end(), arr1.begin(), arr1.end());
    result.insert(result.end(), arr2.begin(), arr2.end());
    return result;
  }
};