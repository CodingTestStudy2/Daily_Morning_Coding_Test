#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(string t, string p) {
    int answer = 0;
    
    unsigned long long pNum = 0;
    
    for(int cnt = 0 ; cnt < p.length() ; ++cnt) {
        pNum *= 10;
        pNum += p[cnt] - '0';
    }
    
    int front = 0;
    int rear = 0;
    
    int size = p.length();
    
    unsigned long long tNum = 0;
    
    while(size--) {
        tNum *= 10;
        tNum += t[rear] - '0';
        ++rear;
    }
    
    if(tNum <= pNum) ++answer;
    
    while(rear < t.length()) {
        tNum -= powl(10, p.length() - 1) * (t[front] - '0');
        tNum *= 10;
        tNum += t[rear] - '0';

        if(tNum <= pNum) ++answer;
            
        ++front;
        ++rear;
    }
    
    
    return answer;
}