class Solution {
    /**
    더 많은 선물을 준 사람이 다음 달에 하나 받는다.
    
    선물 기록이 없거나 주고받은 수가 같다면,
    선물 지수가 큰 사람이 하나 받는다.
    선물 지수가 동일하면 선물 주고받지 않는다. 
    
    선물 지수 = give - take
    
    다음 달에 선물을 가장 많이 받을 친구의 선물 개수 
    */
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        var answer: Int = 0
        val N = friends.size 
        
        val hash = mutableMapOf<String, Int>()
        for((idx, name) in friends.withIndex()){
            hash[name] = idx
        }
        
        val score = mutableMapOf<String, Int>()
        val arr = MutableList(N){ MutableList(N) { 0 } }
        
        for(gift in gifts){
            val temp = gift.split(" ")
            val giveName = temp[0]
            val takeName = temp[1]
            
            val i = hash[giveName] ?: 0
            val j = hash[takeName] ?: 0
            arr[i][j]++
            
            score[giveName] = (score[giveName] ?: 0) + 1
            score[takeName] = (score[takeName] ?: 0) - 1
        }
    
        // 최종 계산
        val candidates = MutableList(N) { 0 }
        for(i in arr.indices){
            for(j in arr[i].indices){
                // 같은 케이스에 대해 중복 연산 방지 
                if(i > j) continue
                
                // 대각선 방향으로 선물 개수 비교 
                if(arr[i][j] > arr[j][i]){
                    candidates[i]++
                }else if(arr[i][j] < arr[j][i]){
                    candidates[j]++
                }else{
                    // 선물 지수 비교
                    val first = score[friends[i]] ?: 0
                    val second = score[friends[j]] ?: 0
                    
                    if(first > second){
                        candidates[i]++
                    }else if(first < second){
                        candidates[j]++
                    }
                }
            }
        }
        
        return candidates.maxOrNull() ?: 0
    }
}