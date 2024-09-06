#include <string>
#include <vector>
#include <queue>

using namespace std;

int answer;
queue<pair<string&,int>> q;
int visit[51];
string _target;
vector<string> _words;

void bfs()
{   
    while(!q.empty())
    {
        pair<string&,int> elem = q.front();
        q.pop();
        
        string& word = elem.first;
        int cnt = elem.second;
        
        if(word == _target)
        {
            answer = cnt;
            return;
        }
        
        for(int cnt = 0 ; cnt < _words.size() ; ++cnt)
        {
            if(visit[cnt] == 1) continue;
            
            int sameCnt = 0;
            for(int i = 0 ; i < word.size() ; ++i)
            {
                if(word[i] == _words[cnt][i]) ++sameCnt;
            }
        
            if(sameCnt == 2)
            {
                q.push({_words[cnt], cnt + 1});
                visit[cnt] = 1;
            }
        }
    }
}

int solution(string begin, string target, vector<string> words) {
    _target = target;
    _words = words;
    for(int cnt = 0 ; cnt < words.size() ; ++cnt)
    {
        if(visit[cnt] == 1) continue;
        
        int sameCnt = 0;
        for(int i = 0 ; i < begin.size() ; ++i)
        {
            if(begin[i] == words[cnt][i]) ++sameCnt;
        }
        
        if(sameCnt == 2)
        {
            q.push({words[cnt], 1});
            visit[cnt] = 1;
        }
    }
    
    bfs();
    
    return answer;
}

/*

begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 한다.

한 번에 한 개으 ㅣ알파벳만 바꿀 수 있다.
words에 있는 단어로만 변환가능

*/