#include <string>
#include <vector>
#include <queue>

using namespace std;

struct compare
{
    bool operator()(int& a, int& b)
    {
        return a < b;
    }
};

priority_queue<int, vector<int>, compare> pq;
queue<pair<int,int>> prioritiesQ;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    
    int counter = 0;
    
    for(int priority : priorities) {
        prioritiesQ.push({priority, counter++});
        pq.push(priority);
    }
    
    int pos = 1;
    while(!prioritiesQ.empty()) {
        pair<int,int> qFront = prioritiesQ.front();
        prioritiesQ.pop();
        
        int pqTop = pq.top();
        
        if(qFront.first < pqTop) {
            prioritiesQ.push(qFront);
        }
        else {
          pq.pop();
        
            if(qFront.second == location) {
                answer = pos;
                break;
            }
            
            ++pos;
        }
        
        
        
    }
    
    return answer;
}