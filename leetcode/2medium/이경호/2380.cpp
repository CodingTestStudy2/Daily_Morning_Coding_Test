#include<string>
#include<deque>
using namespace std;

class Solution {
public:
  string oneRepetition(string s) {
    deque<char> cs;
    string temp;
    for (char c : s) {
      cs.push_back(c);
      if (cs.size() == 2) {
        if (cs.front() == '0' && cs.back() == '1') {
          temp += "10";
          cs.pop_front();
          cs.pop_front();
        }
        else {
          temp += cs.front();
          cs.pop_front();
        }
      }
    }
    if (cs.size()) {
      temp += cs.front();
    }
    return temp;
  }
  bool sortCheck(string s) {
    char current = '1';
    for (char c : s) {
      if (current == '1' && current != c) {
        current = '0';
      }
      if (current == '0' && current != c) {
        return false;
      }
    }
    return true;
  }
  int secondsToRemoveOccurrences(string s) {
    int answer = 0;
    while (!sortCheck(s)) {
      s = oneRepetition(s);
      answer += 1;
    }
    return answer;
  }
};