#include <string>
#include <vector>
#include <unordered_map>
#include <set>

using namespace std;

unordered_map<string, int> id_uMap;

vector<int> reportedCnt;
vector<set<int>> reportingTable;

void Reporting(string& report)
{
    int curIdx = 0;
    
    string subString = "";
    
    int reportingIdx;
    int reportedIdx;
    
    
    while(curIdx != report.size())
    {
        if(report[curIdx] == ' ')
        {
            reportingIdx = id_uMap[subString];
            
            subString.clear();
        }
        else
        {
            subString += report[curIdx];
        }
        
        ++curIdx;
    }
    
    
    reportedIdx = id_uMap[subString];
    
    if(reportingTable[reportedIdx].find(reportingIdx) == reportingTable[reportedIdx].end())
    {
        reportedCnt[reportedIdx]++;
    }
    
    
    reportingTable[reportedIdx].insert(reportingIdx);

}

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    reportedCnt.resize(id_list.size(), 0);
    reportingTable.resize(id_list.size(), set<int>());
    
    for(int cnt = 0 ; cnt < id_list.size() ; ++cnt)
    {
        id_uMap.insert({id_list[cnt], cnt});
    }
    
    for(int cnt = 0 ; cnt < report.size() ; ++cnt)
    {
        Reporting(report[cnt]);
    }
    
    vector<int> answer(id_list.size(), 0);
    
    for(int cnt = 0 ; cnt < reportedCnt.size() ; ++cnt)
    {
        if(reportedCnt[cnt] >= k)
        {
            for(auto iter = reportingTable[cnt].begin() ; iter != reportingTable[cnt].end() ; ++iter)
            {
                answer[*iter]++;
            }
        }
    }
    
    return answer;
}

/*

1.각 유저는 한 번에 한 명의 유저를 신고 할 수 있다.
 - 신고 횟수 제한은 없음.
 - 서로 다른 유저를 계속 신고 가능.
 - 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리
 
2. k번 이상 신고된 유저는 정지
 - 정지시 해당 유저를 신고한 모든 유저에게 정지 사실 고지
 - 유저가 신고한 모든 내용을 취합 후, 마지막에 한꺼번에 게시판 이용 정지를 시킨다.

*/