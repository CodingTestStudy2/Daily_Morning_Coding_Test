#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> A, vector<int> B) {
    sort(B.begin(), B.end());
      int answer = 0;
    for(int i=0; i<A.size(); i++) {
        int key = A[i];
        for(int j=0; j<B.size(); j++) {
            if(B[j]>key) {
                B.erase(B.begin()+j);
                answer++;
            }
        }
    }
    
    return answer;
}
