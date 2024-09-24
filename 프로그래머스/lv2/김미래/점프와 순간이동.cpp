#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int solution(int n)
{
    int ans = 0;
    int start = 0;
    int end = n;
    vector<int> order;
    while(n != 1){
        order.push_back(n);
        n/=2;
    }
    sort(order.begin(), order.end());
    
    int i=0;
    while(start < end){
        
        if(start == 0){
            ans++;
            start++;
        }else{
            if(start *2 <= order[i]){
                start *= 2;
                
                if(start == order[i]){
                    i++;
                }
            }else{
                start++;
                i++;
                ans++;
            }
        }
    }
    
    return ans;
}
