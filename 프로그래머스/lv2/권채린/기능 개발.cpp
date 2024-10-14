#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    
    while(!progresses.empty()) {
        for(int i=0; i<progresses.size(); i++) {
            progresses[i] += speeds[i];
        }
        int n=0;
        if(progresses[0]>=100) {
            n++;
            for(int i=1; i<progresses.size(); i++) {
                if(progresses[i]>=100) {
                    n++;
                } else break;
            }
            answer.push_back(n);
            for(int i=0; i<n; i++) {
                progresses.erase(progresses.begin());
                speeds.erase(speeds.begin());
            }
        } 
    }
    return answer;
}
