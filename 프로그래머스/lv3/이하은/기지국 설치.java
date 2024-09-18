/**
모든 아파트에 기지국의 전파가 도달할 수 있도록 
최소한의 기지국만 추가 설치하자.

현재 기지국이 설치된 위치 중심으로 탐색 (stations 배열 순회) 
기지국의 전파 범위 밖인 경우, 새 기지국 설치 후 전파 범위 밖으로 이동 
기지국의 전파 범위 안인 경우, 전파 범위 밖으로 이동 
*/
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int now = 1;
        int stIdx = 0;
        
        while(now <= n){
            // 초기에 설치된 기지국을 모두 탐색했거나
            // 기지국의 전파 범위에 못 미치는 경우
            if(stIdx >= stations.length || now < stations[stIdx] - w){
                // 새 기지국 설치 후 
                answer++;
                
                // 전파 범위 밖으로 이동 
                now += 2 * w + 1;
            }else{
                // 기지국의 전파 범위 안에 있는 경우 
                // 전파 범위 밖으로 이동
                now = stations[stIdx] + w + 1;
                stIdx++;
            }
        }

        return answer;
    }
}