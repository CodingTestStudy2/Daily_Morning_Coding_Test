#include <string>
#include <vector>
#include <sstream>
#include <iostream>
#include <string>
#include <map>
using namespace std;
map<string, char> newChar;

string change(string str) {
    string result = "";
    
    for(int i = 0; i < str.length(); i++) {
        if(i < str.length() - 1 && str[i+1] == '#') {
         
            string tmp = str.substr(i, 2);
            result += newChar[tmp];  
            i++; 
        } else {
            result += str[i];  
        }
    }
    
    return result;
}

string solution(string m, vector<string> musicinfos) {
    string answer = "";
    vector<vector<string>> info(musicinfos.size()); 
    int maxPlay = 0;
    
    newChar["C#"] = 'Q';
    newChar["D#"] = 'R';
    newChar["F#"] = 'S';
    newChar["G#"] = 'T';
    newChar["A#"] = 'U';
    
    m = change(m);
    
    for(int i=0; i<musicinfos.size(); i++){
        istringstream is(musicinfos[i]);
        string temp;
        int startTime, endTime;
        string st, et;
        int count = 1;
        while(getline(is, temp, ',')){
            
            if(count == 1){
                startTime = stoi(temp.substr(0,2))*60 + stoi(temp.substr(3,2));
            }else if(count == 2){
                endTime = stoi(temp.substr(0,2))*60 + stoi(temp.substr(3,2));
                info[i].push_back(to_string(endTime-startTime));
            }else if(count == 3){
                info[i].push_back(temp);
            }
            else if(count ==4){
                temp = change(temp);
                info[i].push_back(temp);
                info[i].push_back(to_string(temp.length()));
            }
            count++;
        }
    }
    
    for(int i=0; i<musicinfos.size(); i++){
        // cout<<"시작: "<<info[i][0]<<" "<<info[i][1]<<" "<<info[i][2]<<" "<<info[i][3]<<"\n";
        if(stoi(info[i][3]) >= stoi(info[i][0])) // 음악길이 >= 재생 시간, 즉 틀다가 중간에 끊김
        {
            if(info[i][2].find(m) != string::npos && stoi(info[i][0]) >= maxPlay){
                maxPlay = stoi(info[i][0]);
                answer = info[i][1];
            }
        }else{//음악길이 < 재생 시간
            string addStr ="";
            while(addStr.length() < stoi(info[i][0])){
                if((addStr.length() + info[i][2].length()) <= stoi(info[i][0])){
                    addStr += info[i][2];
                }else{
                    int diff = stoi(info[i][0]) - addStr.length();
                    addStr += info[i][2].substr(0, diff);
                }
                
                if(addStr.find(m) != string::npos && stoi(info[i][0]) >= maxPlay){
                     maxPlay = stoi(info[i][0]);
                     answer = info[i][1];
                     break;
                }
            }
        }
    }
    
    return answer;
}
