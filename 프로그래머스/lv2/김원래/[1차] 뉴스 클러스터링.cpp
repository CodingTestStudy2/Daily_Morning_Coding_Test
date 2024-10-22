#include <string>
#include <unordered_map>

using namespace std;

unordered_map<string, int> strMap1;
unordered_map<string, int> strMap2;


bool Check(string& s)
{
    if(s[0] >= 'a' && s[0] <= 'z'&& s[1] >= 'a' && s[1] <= 'z') return true;
    return false;
}

int solution(string str1, string str2) {
    int answer = 0;
    
    for(int cnt = 0 ; cnt < str1.size() ; ++cnt) {
        if('A' <= str1[cnt] && 'Z' >= str1[cnt]) {
            str1[cnt] += 'a' - 'A';
        }
    }
    
    for(int cnt = 0 ; cnt < str2.size() ; ++cnt) {
        if('A' <= str2[cnt] && 'Z' >= str2[cnt]) {
            str2[cnt] += 'a' - 'A';
        }
    }

    
    for(int cnt = 0 ; cnt < str1.size() - 1 ; ++cnt) {
        string key = str1.substr(cnt, 2);
        
        if(Check(key) == false) continue;
        
        if(strMap1.find(key) == strMap1.end()) {
            strMap1.insert({key, 0});
        }
        
        strMap1[key]++;
    }
    
    for(int cnt = 0 ; cnt < str2.size() - 1 ; ++cnt) {
        string key = str2.substr(cnt, 2);
        
        if(Check(key) == false) continue;
        
        if(strMap2.find(key) == strMap2.end()) {
            strMap2.insert({key, 0});
        }
        
        strMap2[key]++;
    }
    
    int totalNum = 0;
    int sameNum = 0;
    
    for(auto mapIter = strMap1.begin() ; mapIter != strMap1.end() ; ++mapIter) {
        string key = (*mapIter).first;
        int val = (*mapIter).second;
        
        if(strMap2.find(key) != strMap2.end()) {
            sameNum += min(strMap1[key],strMap2[key]);
            totalNum += max(strMap1[key], strMap2[key]);
        }
        else {
            totalNum += strMap1[key];
        }

    }

    
    
    for(auto mapIter = strMap2.begin() ; mapIter != strMap2.end() ; ++mapIter) {
        string key = (*mapIter).first;
        
        if(strMap1.find(key) == strMap1.end()) {
            totalNum += strMap2[key];
        }

    }
    
    long long res;
    
    
    
    if(totalNum == 0) {
        res = 1 * 65536;
    }
    else res = 65536 * sameNum / totalNum;
    
    answer = res;
    
    return answer;
}


/*

1. 대문자를 소문자로 변경한다. (str, str2)
2. str1과 str2를 두 개씩 끊어서 unordered_map에 넣는다. - 중복으로 있다면 숫자를 증가 시킨다.
3. str1과 str2를 저장한 unordered_map을 통합하여 합집합의 수를 구한다.
 - str1을 폴링을 돌 때에는 str2에서 교집합인 경우에 더하기도 추가적으로 한다.
 - str2를 폴링을 앞 쪽 연산에서 했기 떄문에 exclusive한 것만 더하기를 한다.


*/