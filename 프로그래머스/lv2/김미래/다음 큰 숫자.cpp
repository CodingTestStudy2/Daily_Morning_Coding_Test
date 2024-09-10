#include <string>
#include <vector>
#include <iostream>
using namespace std;
int count(int n){
    int one = 0;
    while(n>=1){
        if(n%2 != 0){
            one ++;
        }
        n /= 2;
    }
    return one;
}
int solution(int n) {
    int answer = 0;
    
    int correct = count(n);
    cout<<correct;
    while(1){
        n++;
        if(correct == count(n)){
            answer = n;
            break;
        }
    }
    
    return answer;
}
