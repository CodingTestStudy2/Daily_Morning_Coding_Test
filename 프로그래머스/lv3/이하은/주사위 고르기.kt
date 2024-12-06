/*
n개 중에 n/2개 선택 -> 순서X, 중복X -> 조합
n/2개로 만들 수 있는 주사위 합 구하기 -> 6^(n/2), 중복 순열 
주사위 합의 대소 비교 (이분 탐색)
-> A가 이기려면 어떤 주사위를 선택해야 하는지 리턴 
*/
class Solution {
    lateinit var arr: Array<IntArray>
    var N = 0 
    var selected = BooleanArray(10){false}
    var diceA = mutableListOf<Int>() // A가 선택한 주사위 인덱스
    var diceB = mutableListOf<Int>()
    val sumA = mutableListOf<Int>() // A의 주사위로 가능한 합 
    val sumB = mutableListOf<Int>() 
    var awinMaxCnt = -1 
    var answer = IntArray(5){0} // A가 이기기 위한 인덱스 오름차순 정렬  
    
    fun solution(dice: Array<IntArray>): IntArray {
        arr = dice 
        N = dice.size 
        
        dfs(0, 0)
        
        return answer.sliceArray(0..N/2-1)
    }
    
    // n개 중에 n/2개 선택
    // idx: 현재 탐색 중인 인덱스, cnt: 뽑은 개수 
    fun dfs(idx: Int, cnt: Int){
        if(cnt == N/2){
            handleSelectedDice()
            initArrayForNextCase()
            return
        }
        
        for(i in idx until N){
            if(!selected[i]){
                selected[i] = true
                diceA.add(i)
                
                dfs(i + 1, cnt + 1)
                
                selected[i] = false
                diceA.removeAt(diceA.lastIndex)
            }
        }
    }
    
    fun handleSelectedDice() {
        for(i in 0..N-1){
            if(!selected[i]){
                diceB.add(i)
            }
        }

        // n/2개로 만들 수 있는 주사위 합 구하기
        calcSum(idx = 0, sum = 0, isA = true, selectedDice = diceA)
        calcSum(idx = 0, sum = 0, isA = false, selectedDice = diceB)

        // 이분 탐색으로 대소 비교해서 
        // A가 이긴 횟수 구하기 
        var awinCnt = binarySearch()
        
        // A가 이긴 횟수의 최댓값, 정답 갱신 
        if (awinCnt > awinMaxCnt){
            awinMaxCnt = awinCnt

            for(i in 0 until N/2){
                answer[i] = diceA[i] + 1
            }
        }
    }
    
    fun initArrayForNextCase() {
        diceB.clear()
        sumA.clear()
        sumB.clear()
    }

    // N/2개의 주사위로 가능한 합 구하기 -> 6^(N/2)
    fun calcSum(idx: Int, sum: Int, isA: Boolean, selectedDice: List<Int>){
        if(idx == N/2){
            if(isA){
                sumA.add(sum)
            }else{
                sumB.add(sum)
            }
            return
        }
        
        for(i in 0..5){
            val diceIdx = selectedDice[idx]
            calcSum(
                idx = idx + 1,
                sum = sum + arr[diceIdx][i], 
                isA = isA, 
                selectedDice = selectedDice
            )
        }
    }
    
    fun binarySearch(): Int {
        sumB.sort() // 오름차순 정렬 
        val cache = hashMapOf<Int, Int>() // (A 주사위의 합, 이긴 횟수)
        var awinCnt = 0 // A가 이긴 횟수 (B의 합보다 큰 경우의 수)
        
        for(asum in sumA){
            if(cache.containsKey(asum)){
                awinCnt += cache[asum]!!
                continue 
            }
            
            var left = 0
            var right = sumB.size
            
            // true 구간의 최댓값 구하기 
            while(left + 1 < right){
                var mid = (left + right) / 2
                
                if(asum > sumB[mid]){
                    left = mid // 최댓값으로 이동 
                }else{
                    right = mid // B의 합이 더 작아지도록 
                }
            }
            
            // A가 이긴 횟수 저장 
            cache.put(asum, left) 
            awinCnt += left 
        }
        
        return awinCnt
    }
}