#include <string>
#include <vector>
#include <map>

using namespace std;

vector<int> solution(vector<string> name, vector<int> yearning, vector<vector<string>> photo) {
    vector<int> answer;
    map<string,int> m;
    
    for(int i=0;i<name.size();i++)
    {
        m.insert({name[i],yearning[i]});
    }
    for(int i=0;i<photo.size();i++)
    {
        int num=0;
        for(int j=0;j<photo[i].size();j++)
        {
            if(m.count(photo[i][j])==1)
            {
                num+=m[photo[i][j]];
            }
        }
        answer.push_back(num);
    }
    
    
    
    return answer;
}
