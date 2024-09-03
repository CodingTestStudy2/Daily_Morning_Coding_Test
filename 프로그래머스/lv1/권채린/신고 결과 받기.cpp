#include <string>
#include <vector>
#include <map>
#include <set>

using namespace std;

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer;
    map<string, set<string> report_list; // from, to
    map<string, int> id_count;  // 신고당한 횟수
    
    for (int i=0; i<report.size(); i++) {
        int blank = report[i].find(" ");
        string from = report[i].substr(0, blank);
        string to = report[i].substr(blank); // 공백 이후부터 to를 추출
        
        if (report_list[from].find(to) == report_list[from].end()) {
            report_list[from].insert(to);
            id_count[to]++;
        }
    }

    for (string s : id_list) {
        int mail=0;
        for(string str : report_list[s]) {
            if(id_count[str]>=k) {
                mail++;
            }
        }
        answer.push_back(mail);
        
    }

    return answer;
}
