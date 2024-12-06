/*
각 배열에서 최대공약수를 구한다. 
A 배열은 모두 나머지 == 0 
B 배열은 모두 나머지 != 0
=> 가능한 최대공약수가 없다면 0을 리턴 
*/
class Solution {
    fun solution(arrA: IntArray, arrB: IntArray): Int {
        // A의 최대공약수
        var ga = arrA[0]
        for(i in 1 until arrA.size){
            ga = gcd(ga, arrA[i])
        }
        
        // B의 최대공약수
        var gb = arrB[0]
        for(i in 1 until arrB.size){
            gb = gcd(gb, arrB[i])
        }
        
        var found = true
        if(ga > gb){
            for(num in arrB){
                if(num % ga == 0) {
                    found = false
                    break
                }
            }
            
            if(found) return ga
        }else{
            for(num in arrA){
                if(num % gb == 0) {
                    found = false
                    break
                }
            }
            
            if(found) return gb
        }
        
        return 0
    }
    
    fun gcd(a: Int, b: Int): Int {
        if(a % b == 0){
            return b
        }else{
            return gcd(b, a % b)
        }
    }
}