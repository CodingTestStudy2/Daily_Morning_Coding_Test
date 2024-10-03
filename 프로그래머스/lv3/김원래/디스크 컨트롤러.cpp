#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

bool compare1(vector<int>& a, vector<int>& b) {
    return a[0] < b[0];
}

struct compare2 {
  bool operator()(vector<int>& a, vector<int>& b) {
      return a[1] > b[1];
  }  
};

priority_queue<vector<int>, vector<vector<int>>, compare2> pq;

int solution(vector<vector<int>> jobs) {
    int answer = 0;
    
    sort(jobs.begin(), jobs.end(), compare1);
    
    int startTime = jobs[0][0];
    int curIdx = 0;
    
    while(curIdx < jobs.size()) {
        while(curIdx < jobs.size() && jobs[curIdx][0] <= startTime) {
            pq.push(jobs[curIdx]);
            ++curIdx;
        }
        
        if(pq.empty()) {
            ++startTime;
            continue;
        }
        
        vector<int> top = pq.top();
        pq.pop();
        
        answer += (startTime - top[0]) + top[1];
        
        startTime += top[1]; 
    }
    
    while(!pq.empty()) {
        vector<int> top = pq.top();
        pq.pop();
        
        answer += (startTime - top[0]) + top[1];
        
        startTime += top[1]; 
    }
    
    answer /= jobs.size();
    
    return answer;
}

/*



*/