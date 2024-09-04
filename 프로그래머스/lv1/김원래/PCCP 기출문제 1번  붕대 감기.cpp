#include string
#include vector

using namespace std;

int solution(vectorint bandage, int health, vectorvectorint attacks) {
    
    int bandageTime = bandage[0];
    int hps = bandage[1];
    int addh = bandage[2];
    
    int curHealth = health;
    int curTime = 0;
    
    int curBandageTime;
    
    for(int cnt = 0 ; cnt  attacks.size() ; ++cnt)
    {
        int attackTime = attacks[cnt][0];
        int hillTime = (attackTime - curTime) - 1;  첫 예제에서는 처음에 1
        
        int totalHill = (hillTime  hps) + (hillTime  bandageTime)  addh;
        
        curHealth += totalHill;
        if(curHealth  health) curHealth = health;
        
        curHealth -= attacks[cnt][1];
        
        curTime = attackTime;
            
        if(curHealth = 0) return -1;
    }
    
    
    return curHealth;
}


붇대감기
 - t초 동안 붕대를 감음
 - 1초마다 x만큼의 체력 회복
 - t초 연속으로 붕대를 감는데 성공하면 y만큼의 체력을 회복

최대 체력을 초과해서 회복은 불가

붕대감기 쓰는 동안 몬스터에게 공격 당하면 취소됨
연속 성공 시간이 0이 됨 

공격을 당하면 체력이 줄어듬

캐릭터가 생존 할 수 있는가


