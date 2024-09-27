#include <string>
#include <vector>
#include <iostream>
#include <unordered_set>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> answer;
    
    int orderCnt = 0;
    
    unordered_set<string> visitSet;
    
    visitSet.insert(words[0]);
    
    for(int cnt = 1 ; cnt < words.size() ; ++cnt)
    {
        orderCnt++;
        if(visitSet.find(words[cnt]) != visitSet.end() || 
           words[cnt][0] != words[cnt-1][words[cnt-1].size()-1])
        {
            answer.push_back(cnt % n + 1);
            answer.push_back((orderCnt + n) / n);
            break;
        }
        else visitSet.insert(words[cnt]);
           
    }
    
    if(answer.empty()) answer.resize(2, 0);

    return answer;
}


/*

//차례를 나타내는 변수
int orderCnt;


//말한 단어의 중복체크
unordered_set<string> visitWords;



for(word : words)
{
    if(find != end)
        : 중복이기 떄문에 탈락
}

if(탈락자 x)
    : 0,0을 추가

*/