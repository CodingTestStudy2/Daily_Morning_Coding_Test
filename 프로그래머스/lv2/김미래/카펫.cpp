#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    int length = (brown - 4) /2 ; // 노란색의 가로 + 세로 길이
    int garo = 0;
    
    for(int i=1; i<length; i++){
        garo = length - i;
        if(garo * i == yellow){
            break;
        }
    }
    
    if(garo > length-garo){
        answer.push_back(garo+2);
        answer.push_back(length-garo+2);
    }else{
        answer.push_back(length-garo+2);
        answer.push_back(garo+2);
    }
    
    
    return answer;
}
