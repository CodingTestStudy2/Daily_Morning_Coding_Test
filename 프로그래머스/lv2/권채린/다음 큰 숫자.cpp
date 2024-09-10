#include <string>
#include <vector>

using namespace std;

int binary(int num) {
    string bi = "";
    int count=0;
    
    while(num>0) {
        bi = to_string(num%2)+bi;
        if( num%2 == 1) {
            count++;
        }
        num /= 2;
    }
    return count;
    
}


int solution(int n) {
    int answer = n;
    int goal = binary(n);
    
    while(1) {
        answer++;
        if(goal == binary(answer))
            break;
    }
    
    return answer;
    
}
