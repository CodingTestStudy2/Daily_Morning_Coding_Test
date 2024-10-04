#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

unordered_map<string, int> yearnings;

vector<int> solution(vector<string> name, vector<int> yearning, vector<vector<string>> photo) {
    vector<int> answer;
    
    for(int cnt = 0 ; cnt < name.size(); ++cnt)
    {
        yearnings.insert({name[cnt], yearning[cnt]});
    }
    
    for(int photoCnt = 0 ; photoCnt < photo.size() ; ++photoCnt)
    {
        int score = 0;
        for(string s : photo[photoCnt])
        {
            if(yearnings.find(s) != yearnings.end())
            {
                score += yearnings[s];
            }
        }
        
        answer.push_back(score);
    }
    
    return answer;
}

/*



*/