#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> data, string ext, int val_ext, string sort_by) {
    vector<vector<int>> answer;
    
    int dataIdx;
    
    if(ext == "code")
        dataIdx = 0;
    else if(ext == "date")
        dataIdx = 1;
    else if(ext == "maximum")
        dataIdx = 2;
    else
        dataIdx = 3;
    
    
    for(int cnt = 0 ; cnt < data.size() ; ++cnt)
    {
        if(data[cnt][dataIdx] < val_ext)
            answer.push_back(data[cnt]);
    }
    
    int sortIdx;
    if(sort_by == "code")
        sortIdx = 0;
    else if(sort_by == "date")
        sortIdx = 1;
    else if(sort_by == "maximum")
        sortIdx = 2;
    else
        sortIdx = 3;
    
    for(int i = answer.size() - 1 ; i > 0 ; --i)
    {
        for(int j = 0 ; j < i ; ++j)
        {
            if(answer[j][sortIdx] > answer[j+1][sortIdx])
            {
                vector<int> tmp = answer[j];
                answer[j] = answer[j+1];
                answer[j+1] = tmp;
            }
        }
    }
    
    
    return answer;
}