#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int solution(vector<int> nums) {
    int answer = 0;
    vector<bool> temp(nums.size(), false);
    fill(temp.end()-3, temp.end(), true);
    do{
        int result = 0;
        for(int i=0; i<nums.size(); i++){
            if(temp[i]==true){
                result +=nums[i];
            }
        }
        
        for(int j=2; j<result; j++){
            if(result % j == 0){
                break;
            }
            if(j == result -1){
                answer++;
            }
        }
    }while(next_permutation(temp.begin(), temp.end()));

    return answer;
}
