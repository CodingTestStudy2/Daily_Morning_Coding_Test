## 구현 

```kotlin
class Solution {
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

## Short Code

```kotlin
class Solution {
    fun solution(s: String): String {
        return s.toLowerCase().split(" ").joinToString(" "){ it.capitalize() }
    }
}
```