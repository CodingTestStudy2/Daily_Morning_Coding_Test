#include <iostream>
#include <vector>
using namespace std;
int solution(int n, vector<int> stations, int w)
{
    int answer = 0;
    int range = 2*w + 1;
    int start = 1;
    
    for(int i=0; i<stations.size(); i++){
       int boundary = stations[i] - w;
        if(start < boundary){
            int leng = boundary - start;
            if(leng <= range){
                answer +=1;
            }else{
                answer += leng/range;
                if(leng % range != 0){
                    answer += 1;
                }
            }
        }
        
        start = stations[i] + w + 1;
    }
    
    if(start<=n){
        answer += (n - start + 1) / range;
        if((n-start+1) % range != 0){
            answer +=1;
        }
    }

    return answer;
}
