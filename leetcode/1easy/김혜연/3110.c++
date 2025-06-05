#include <vector> 
#include <utility>

<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
public:
    vector<pair<bool,bool>> alpha;

    int numberOfSpecialChars(string word) {
        alpha.resize(27);

        for (char c : word){
            if (c >= 'A' && c <= 'Z')
                alpha[c-'A'].first = true;
            else
                alpha[c-'a'].second = true;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++){
            if (alpha[i].first && alpha[i].second)
                ans++;
        }

        return ans;
    }
};