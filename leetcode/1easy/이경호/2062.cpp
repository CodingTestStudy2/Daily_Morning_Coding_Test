#include <string>
#include <set>;

using namespace std;

class Solution {
public:
  int countVowelSubstrings(string word) {
    int result = 0;
    set<char> comp;
    comp.insert('a');
    comp.insert('e');
    comp.insert('i');
    comp.insert('o');
    comp.insert('u');
    for (int left = 0; left < word.length(); left++) {
      set<char> cont;
      for (int right = left; right < word.length(); right++) {
        if (comp.find(word[right]) == comp.end()) {
          break;
        }
        cont.insert(word[right]);
        if (cont.size() == comp.size()) {
          result++;
        }
      }
    }
    return result;
  }
};