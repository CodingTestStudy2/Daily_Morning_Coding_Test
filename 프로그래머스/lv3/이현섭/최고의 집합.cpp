#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, int s) {
    vector<int> answer;
    int now = s/n;
    if(now<1)
        return {-1};
    
    for(int i=0;i<n;i++)
    {
        answer.push_back(now);
    }
    for(int i=0;i<s%n;i++)
    {
        answer[n-i-1]+=1;
    }
    
    return answer;
}
