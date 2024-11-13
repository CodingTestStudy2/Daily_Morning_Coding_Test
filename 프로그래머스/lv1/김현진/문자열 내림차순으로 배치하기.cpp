//vector에 안 넣고 그냥 string을 sort 하는 것도 가능하다고 한다..대박

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string s) {
    string answer = "";
    vector<char> vec;
    for(int i=0;i<s.size();i++)
    {
        vec.push_back(s[i]);
    }
    sort(vec.begin(),vec.end(),greater<char>());
    for(auto c : vec)
        answer += c;
    return answer;
}
