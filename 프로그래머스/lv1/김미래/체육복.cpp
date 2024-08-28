#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    answer = n - lost.size();
    
    sort(lost.begin(), lost.end());
    sort(reserve.begin(), reserve.end());
    
        for(int i=0; i<reserve.size(); i++){
          for(int j=0; j<lost.size(); j++){
            if(reserve[i] != -1 && lost[j] != -1){
                if(lost[j] == reserve[i]){
                    lost[j] = -1;
                    reserve[i] = -1;
                    answer++;
                    continue;
                }
            }
        }
    }
    
    for(int i=0; i<reserve.size(); i++){
        for(int j=0; j<lost.size(); j++){
            if(reserve[i] != -1 && lost[j] != -1){
                if(lost[j] == reserve[i]-1 || lost[j] == reserve[i]+1){
                    lost[j] = -1;
                    reserve[i] = -1;
                    answer++;
                    continue;
                    }
                }
        }
    }
    return answer;
}
