#include <string>
#include <vector>
#include <queue>

using namespace std;

priority_queue<int, vector<int>, greater<int>> pq;

vector<int> solution(int k, vector<int> score) {
    vector<int> answer;
    
    for(int _score : score)
    {
        pq.push(_score);
        if(pq.size() > k) pq.pop();
        
        answer.push_back(pq.top());
    }
    
    return answer;
}


/*

score를 폴링하면서 pq에 추가한다. pq는 오름차순으로 관리를 하고 pq의 size가 k보다 커지면 pq를 pop한다.

*/