#include <string>
#include <vector>
#include <sstream>
#include <map>
using namespace std;

int solution(vector<string> friends, vector<string> gifts) {
    int answer = 0;
    vector<vector<int>> history(friends.size(), vector<int> (friends.size(), 0));
    vector<int> degree(friends.size(), 0);
    map<string, int> index;
    
    for(int i=0; i<friends.size(); i++){
        index[friends[i]] = i;
    }
    
    for(int j=0; j<gifts.size(); j++){
        istringstream str(gifts[j]);
        string send, recieve;
        str >> send >> recieve;
        
        history[index[send]][index[recieve]] += 1;
    }
    
    for (int i = 0; i < history.size(); i++) {
        for (int j = 0; j < history.size(); j++) {
            degree[i] += history[i][j]; 
            degree[i] -= history[j][i];  
        }
    }

    
    for(int i=0; i< history.size(); i++){
        int now = 0;
        for(int j=0; j<history.size(); j++){
            if(i == j) continue;
            
            if(history[i][j] > history[j][i]){
                now ++;
            } else if(history[i][j]==history[j][i]){
                if(degree[i]>degree[j]) now++;
            }
        }
         if (now>answer)
        {
            answer=now;
        }
    }

    return answer;
}
