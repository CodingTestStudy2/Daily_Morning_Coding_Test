#include <string>
#include <vector>
#include <string>
#include <algorithm>
#include <iostream>
using namespace std;

string solution(string X, string Y) {
    string answer = "";
    vector<int> xCount (10, 0);
    vector<int> yCount (10, 0);
    vector<int> result;
    
    for(int i=0; i<X.length(); i++){
        for(int j=0; j<xCount.size(); j++){
            int temp = X[i] -'0';
            if(temp==j){
                xCount[j]+=1;
            }
        }
    }
    
    for(int i=0; i<Y.length(); i++){
        for(int j=0; j<yCount.size(); j++){
            int temp = Y[i] -'0';
            if(temp==j){
                yCount[j]+=1;
            }
        }
    }
    
    for(int i=9; i>=0; i--){
        int num = min(xCount[i], yCount[i]);
        for(int j=0; j<num; j++)
            answer+=to_string(i);
        }
    if(answer=="") return "-1";
    else if(answer[0]=='0') return "0";
    else return answer;
}
