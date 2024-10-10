#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    
    
    
    for(vector<int>& command : commands) {
        vector<int> _substr;
        int i = command[0];
        int j = command[1];
        int k = command[2];
        
        for(int idx = i -1 ; idx < j ; ++idx) {
            _substr.push_back(array[idx]);
        }
        sort(_substr.begin(), _substr.end());
        
        answer.push_back(_substr[k-1]);
    }
    
    return answer;
}

/*



*/