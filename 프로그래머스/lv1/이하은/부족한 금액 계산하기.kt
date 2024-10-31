/*
price * (1 + 2 + ... + cnt) -> 필요한 금액 
*/
class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        val required: Long = price.toLong() * (1..count).sum()
        if(required <= money){
            return 0L
        }else{
            return required - money.toLong()
        }
    }
}