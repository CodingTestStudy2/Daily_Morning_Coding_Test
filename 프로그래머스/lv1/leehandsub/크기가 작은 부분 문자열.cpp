#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(string t, string p) {
    int answer = 0;
    string temp;
    
    
    for(int i=0;i<p.size();i++)
    {
        temp.push_back(t[i]);
    }
    if(stoull(temp)<=stoull(p))
        answer++;
    for(int i=p.size();i<t.size();i++)
    {
        temp.erase(temp.begin());
        temp.push_back(t[i]);
        if(stoull(temp)<=stoull(p))
            answer++;
    }
    
    
    
    return answer;
}
