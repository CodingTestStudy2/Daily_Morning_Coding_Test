/*
실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수

각 스테이지에서 도전 중인 유저 수 구하기 
-> freq[stage] = users

스테이지에 도달한 플레이어 수
-> 초기에 stages.size
-> 다음 스테이지로 넘어갈 때마다, 이미 실패율을 구한 유저 수만큼 감소 

스테이지에 도달했으나, 아직 클리어하지 '못한' 플레이어의 수 
-> i번째 스테이지 번호 == stages[i]

실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호 저장 
실패율이 같으면, 작은 번호의 스테이지가 먼저 오도록 
N + 1은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타냄.
*/

class Solution {
    fun solution(N: Int, stages: IntArray): List<Int> {
        // 각 스테이지에서 도전 중인 유저 수 구하기 
        val userMap = mutableMapOf<Int, Int>()
        for(stage in stages){ // 최대 20만 
            userMap[stage] = (userMap[stage] ?: 0) + 1
        }

        // 각 스테이지의 실패율 계산하여 맵에 저장 
        val failMap = mutableMapOf<Int, Double>()
        var totalUsers = stages.size 
        
        for(i in 1..N){ // 최대 500 
            if(userMap.containsKey(i)){
                failMap[i] = (userMap[i]?.toDouble() ?: 0.0) / totalUsers.toDouble()
                totalUsers -= userMap[i] ?: 0
            }else{
                failMap[i] = 0.0
            }
        }
        
        // 기본적으로 스테이지 번호에 따라 오름차순 정렬된 맵 
        // 실패율에 따라 내림차순 정렬 
        return failMap.toList().sortedByDescending{ it.second }.map{ it.first }
    }
}
