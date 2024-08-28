#include <iostream>
#include <string> 
#include <cstring>
#include <sstream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <stack>
#include <queue>
#include <map>
#include <set>
#include <unordered_set>
#include <unordered_map>
using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

// 선택 번호: 1 2 3 4 5 6 7 
// 선택 유형: 0 0 0 - 1 1 1 
// 획득 점수: 3 2 1 0 1 2 3 

// 점수가 더 높은 성격 유형 선택, 점수가 같으면 사전 순으로 선택 
// R T 
// C F 
// J M  
// A N 

map<char, int> m;

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    
    for(int i = 0; i < survey.size(); i++){
        string types = survey[i];
        int choice = choices[i];
        int idx = choice / 4;
        
        if(choices[i] != 4){
            int type = types[idx];
            if(choice > 4){
                m[type] += choice % 4;
            }else{
                m[type] += 4 - (choice % 4);
            }
        }
    }
    
    answer += m['R'] >= m['T'] ? 'R' : 'T';
    answer += m['C'] >= m['F'] ? 'C' : 'F';
    answer += m['J'] >= m['M'] ? 'J' : 'M';
    answer += m['A'] >= m['N'] ? 'A' : 'N';
    
    return answer;
}