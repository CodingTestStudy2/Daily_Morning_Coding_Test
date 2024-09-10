#include <string>
#include <vector>

using namespace std;


int solution(int n) {
    int answer = 0;
    int start = 1, finish = 1;
    int sum = 1;

    while (start <= n) {
        if (sum < n) {
            finish++;
            sum += finish;
        } else if (sum > n) {
            sum -= start;
            start++;
        } else { 
            answer++;
            sum -= start;
            start++;
        }
    }
    
    return answer;
}
