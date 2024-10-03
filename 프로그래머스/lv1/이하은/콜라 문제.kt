import java.util.*

/*
20 -> 10 
10 -> 5 
5 -> 4 -> 2 | empty: 1 + 2 = 3
3 -> 2 -> 1 | empty: 1 + 1 = 2
2 -> 1 | empty: 1 
획득: 10 + 5 + 2 + 1 + 1

20 -> 18 -> 6 | empty: 2 + 6 = 8
8 -> 6 -> 2 | empty: 2 + 2 = 4
4 -> 3 -> 1 | empty: 1 + 1 = 2
획득: 6 + 2 + 1 

while(남은 빈병 개수 >= a)

현재 가진 빈병 개수에서 몇개를 가져갈지 (가장 가까운 a의 배수 찾기)
(가져간 빈병 수 / a) * b -> 획득한 개수 카운팅 
남아있던 빈병 + 획득한 개수 -> a 이상인 경우 반복 
*/
class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0 
        var emptyBottles = n
        
        while(emptyBottles >= a){
            var takenBottles = emptyBottles
            
            // 현재 남은 빈병 수에 가장 가까운 a의 배수 찾기
            while(takenBottles % a != 0){
                takenBottles--
            }
            
            // 그만큼 빈병 가져가기 
            emptyBottles -= takenBottles
        
            // 새로운 빈병 획득 
            emptyBottles += (takenBottles / a) * b 
            
            // 획득한 개수 갱신 
            answer += (takenBottles / a) * b 
        }
        
        return answer
    }
}