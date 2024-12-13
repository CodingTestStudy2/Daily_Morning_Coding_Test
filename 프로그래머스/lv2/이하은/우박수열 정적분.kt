/*
1) 우박 수열 계산 
2) 각 구간별 넓이 계산 
3) [a, b] 영역 넒이 합 리턴 (a 양수, b 음수)
*/
class Solution {
    fun solution(k: Int, ranges: Array<IntArray>): DoubleArray {
        var answer = mutableListOf<Double>()
        val yCoords = getRainSequence(k)
        val areas = DoubleArray(yCoords.size - 1) {0.0}
        
        for(i in 0..yCoords.size-2){
            val y1 = yCoords[i]
            val y2 = yCoords[i+1]
            areas[i] = (y1 + y2) / 2.0
        }
        
        // x = a ~ n + b (a >= 0, b <= 0)
        val n = yCoords.size - 1 
        for(range in ranges){
            val start = range[0]
            val end = n + range[1]
            
            if(start > end){
                answer.add(-1.0)
                continue 
            }
            
            var sum: Double = 0.0
            for(i in start until end){
                sum += areas[i]
            }
            answer.add(sum)
        }
        
        return answer.toDoubleArray()
    }
    
    fun getRainSequence(num: Int): List<Int> {
        var k = num
        val seq = mutableListOf<Int>()
        seq.add(k)
        
        while(k > 1){
            if(k % 2 == 0){
                k /= 2
            }else{
                k *= 3  
                k += 1
            }
            seq.add(k)
        }
        
        return seq
    }
}