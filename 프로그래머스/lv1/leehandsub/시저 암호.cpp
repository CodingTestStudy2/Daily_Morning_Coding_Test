#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(string s, int n) {
    string answer = "";
    
    for(int i=0;i<s.size();i++)
    {
        for(int j=1;j<=n;j++)
        {
            if(s[i]>='a'&&s[i]<='z')
            {
                s[i]++;
                if(s[i]>'z')
                    s[i]='a';
            }
            else if(s[i]>='A'&&s[i]<='Z')
            {
                s[i]++;
                if(s[i]>'Z')
                    s[i]='A';
            }
            cout<<s[i]<<"\n";
        }
    }
    
    return s;
}
