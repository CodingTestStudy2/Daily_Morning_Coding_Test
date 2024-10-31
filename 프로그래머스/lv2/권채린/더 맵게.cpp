#include <string>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int, vector<int>, greater<int>> pq(scoville.begin(), scoville.end());
    
    while(pq.top()<K) {
        if(pq.size()<2) {
            return -1;
        } else  {
        int a = pq.top(); pq.pop();
        int b = pq.top(); pq.pop();
        pq.push(a+b*2);
        answer++;
        } 
    }
    return answer;
}
