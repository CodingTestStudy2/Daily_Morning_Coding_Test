#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
int answer=0;

void isPallin(string s, int left, int right){
    while(left>=0 && right<=s.length()){
        if(s[left] != s[right]) break;
        
        left--;
        right++;
    }
    
    int tmp = right - left - 1;
    answer = max(tmp, answer);
}

int solution(string s)
{
    
    for(int i=0; i<s.length(); i++){
        
       isPallin(s, i, i);
       isPallin(s, i, i+1);
        
    }

    return answer;
}
