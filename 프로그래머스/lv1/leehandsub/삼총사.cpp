#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> number) {
    int answer = 0;
    vector<int> arr(number.size());
    arr[number.size()-1]=1;
    arr[number.size()-2]=1;
    arr[number.size()-3]=1;
    
    do{
        int temp=0;
        for(int i=0;i<arr.size();i++)
        {
            if(arr[i]==1)
            {
                temp+=number[i];
            }
        }
        if(temp==0)
        {
            answer++;
        }
        
    }while(next_permutation(arr.begin(),arr.end()));
    
    
    
    return answer;
}
