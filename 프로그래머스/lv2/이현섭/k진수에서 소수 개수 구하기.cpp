#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

string con(int n,int k)
{
    string temp;
    while(n>=1)
    {
        temp.push_back(n%k+'0');
        n/=k;
    }
    reverse(temp.begin(),temp.end());
    return temp;
}
bool isPrime(long long n)
{
    if(n==1)
        return false;
	for (long long i = 2; i <= sqrt(n); i++) 
    {
		if (n%i == 0) 
        {
			return false;
		}
	}

	return true;
}


int solution(int n, int k) {
    int answer = 0;
    string num = con(n,k);
    string now;
    
    for(int i=0;i<num.size();i++)
    {
        if(num[i]=='0')
        {
            if(now!=""&&isPrime(stoll(now)))
            {
                answer++;
            }
            now="";
        }
        else
        {
            now.push_back(num[i]);
        }
    }
   if(now!=""&&isPrime(stoll(now)))
    {
        answer++;
    }
    
    return answer;
}
