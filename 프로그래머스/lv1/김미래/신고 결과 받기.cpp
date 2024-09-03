#include <string>
#include <vector>
#include <map>
#include <set>
#include <sstream>
using namespace std;

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer(id_list.size(), 0);
    map<string, int> index;
    map<string, set<string>> reportMap;
    
    for(int i=0; i<id_list.size(); i++){
        index[id_list[i]] = i;
    }
    
    for(int i=0; i<report.size(); i++){
        istringstream str(report[i]);
        string reporter, reported;
        str >> reporter >> reported;
        
        reportMap[reported].insert(reporter);
    }
    
    for(int i=0; i<id_list.size(); i++){
        string now = id_list[i];
        if (reportMap[now].size() >= k) { 
            for (string reporter : reportMap[now]) {
                answer[index[reporter]]++;
            }
        }
    }
    
    return answer;
}
