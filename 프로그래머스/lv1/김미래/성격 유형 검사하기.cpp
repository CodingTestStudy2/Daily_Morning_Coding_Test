#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    vector<pair<char,int>> score = {make_pair('R', 0), make_pair('T', 0), make_pair('C', 0), make_pair('F', 0), make_pair('J', 0), make_pair('M', 0), make_pair('A', 0), make_pair('N', 0)};
    
    for(int i=0; i<survey.size(); i++){
        char now;
        int point = 0;
        
        if(choices[i]<=3){
            now = survey[i][0];
            if(choices[i]==1){
                point = 3;
            }else if(choices[i]==2){
                point = 2;
            }else if(choices[i]==3){
                point = 1;
            }
        }else if(choices[i]>=5){
            now=survey[i][1];
            point = choices[i] - 4;
        }
        
        for(int j=0; j<score.size(); j++){
            if(now == score[j].first){
                score[j].second += point;
            }
        }
    }
    
    for(int i=0; i<score.size(); i+=2){
        if(score[i].second < score[i+1].second){
            answer += score[i+1].first;
        }else{
            answer += score[i].first;
        }
    }
    return answer;
}
