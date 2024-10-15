#include <string>
#include <vector>
#include <map>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    map<char,int> m;
    
    for(int i=0;i<s.size();i++)
    {
        if(m.count(s[i])==1)
        {
            answer.push_back(i-m[s[i]]);
            m[s[i]]=i;
        }
        else
        {
            m.insert({s[i],i});
            answer.push_back(-1);
        }
    }
    
    
    return answer;
}
