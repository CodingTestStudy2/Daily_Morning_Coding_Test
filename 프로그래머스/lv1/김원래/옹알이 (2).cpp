#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

unordered_set<string> babblingSet;

bool IsPossible(string& str)
{
    int idx = 0;
    
    string curStr = "";
    string prev = "";
    
    
    while(idx != str.size())
    {
        curStr += str[idx];
        
        if(babblingSet.find(curStr) != babblingSet.end())
        {
            if(prev == curStr) return false;
            else
            {
                if(idx == str.size() - 1) return true;
                
                prev = curStr;
                curStr = "";
            }
        }
        
        ++idx;
    }
    
    
    return false;
}

int solution(vector<string> babbling) {
    int answer = 0;
    
    babblingSet.insert("aya");
    babblingSet.insert("ye");
    babblingSet.insert("woo");
    babblingSet.insert("ma");
    
    
    for(int cnt = 0 ; cnt < babbling.size(); ++cnt)
    {
        if(IsPossible(babbling[cnt]) == true) ++answer;
    }
    
    
    return answer;
}