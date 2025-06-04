# 반복문으로 구현 

```kotlin
class Leetcode.이재훈.이재훈.Solution {
    fun solution(input: String): String {
        var answer = ""
        if(input.isBlank()) return input
        
        var idx = 0
        while(idx < input.length){
            val ch = input[idx]
            if(ch == ' ') {
                answer += ch
                idx++
                continue
            }
            
            val spaceIdx = input.indexOf(" ", startIndex = idx)
            var word = ""
            if(spaceIdx == -1){
                word = input.substring(idx)
            }else{
                word = input.substring(idx, spaceIdx)
            }
            
            if(word.length == 1){
                answer += word.toUpperCase()
            }else{
                val first = word[0].toUpperCase()
                val second = word.substring(1).toLowerCase()
                answer += (first + second)
            }
            
            if(spaceIdx == -1) break
            else idx = spaceIdx
        }
        
        return answer
    }
}
```

# split, map, joinToString

## capitalize() - v1.5부터 deprecated

```kotlin
class Leetcode.이재훈.이재훈.Solution {
    fun solution(input: String) = input.lowercase().split(" ").map {
        it.capitalize()
    }.joinToString(" ")
}
```

## uppercaseChar() 

```kotlin 
class Leetcode.이재훈.이재훈.Solution {
    fun solution(input: String) = input.split(" ").map {
        if(it.isEmpty()) it
        else{
            var lowerWord = it.lowercase().toCharArray()
            lowerWord[0] = lowerWord[0].uppercaseChar() // 문자 하나만 대문자로 변경 
            String(lowerWord) // CharArray to String 
        }
    }.joinToString(" ")
}
```