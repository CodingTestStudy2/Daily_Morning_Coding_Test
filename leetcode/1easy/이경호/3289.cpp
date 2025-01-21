#include <vector>
#include <set>

using namespace std;

class Solution {
public:
  vector<int> getSneakyNumbers(vector<int>& nums) {
    vector<int> answer;
    set<int> exists;
    for (int num : nums) {
      if (exists.find(num) != exists.end()) {
        answer.push_back(num);
      }
      else {
        exists.insert(num);
      }
    }
    return answer;
  }
};