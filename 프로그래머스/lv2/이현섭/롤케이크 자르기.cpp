#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(vector<int> topping) {
    int answer = 0;
    map<int,int> arr1;
    map<int,int> arr2;
    
    for(int i=0;i<topping.size();i++)
    {
        if(arr2.count(topping[i])==0)
        {
            arr2.insert({topping[i],1});
        }
        else
        {
            arr2[topping[i]]++;
        }
    }
    for(int i=0;i<topping.size();i++)
    {
        if(arr1.count(topping[i])==0)
        {
            arr1.insert({topping[i],1});
        }
        else
        {
            arr1[topping[i]]++;
        }
        arr2[topping[i]]--;
        if(arr2[topping[i]]==0)
        {
            arr2.erase(arr2.find(topping[i]));
        }
        
        if(arr1.size()==arr2.size())
            answer++;
        
    }
    
    
    return answer;
}
