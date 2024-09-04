#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(vector<int> bandage, int health, vector<vector<int>> attacks) {
    int answer = 0;
    int maxHealth = health;
    int time = 0;
    int attackIndex =0;
    
    for(int i=1; i<=attacks[attacks.size()-1][0]; i++){
        if(i == attacks[attackIndex][0]){
            health -= attacks[attackIndex][1];
            time = 0;
            attackIndex++;
            if(health<=0) return -1;
        }
        else{
            health += bandage[1];
            time++;
            
            if(time == bandage[0]){
                health += bandage[2];
                time = 0;
            }
            if(health>=maxHealth){
                health = maxHealth;
            }
        }
        
    }
    
    answer = health;
    return answer;
}
