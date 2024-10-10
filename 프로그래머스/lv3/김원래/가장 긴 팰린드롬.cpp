#include <iostream>
#include <string>
using namespace std;
int solution(string s)
{
    int answer=0;

    
    for(int mid = 0 ; mid < s.size() ; ++mid) {
        int left = mid - 1;
        int right = mid + 1;
        
        int res = 1;
        
        while(left >= 0 && right < s.size()) {
            
            if(s[left] == s[right]) res += 2;
            else break;
            --left;
            ++right;
        }
        
        answer = max(answer, res);
    }
    
    
    for(int l = 0 ; l < s.size() ; ++l) {
        int left = l;
        int right = l + 1;
        
        int res = 0;
        
        while(left >= 0 && right < s.size()) {
            
            if(s[left] == s[right]) res += 2;
            else break;
            left--;
            right++;
        }
        
        
        answer = max(answer, res);
    }
    

    return answer;
}