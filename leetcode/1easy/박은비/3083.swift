/*
    문자열에서 길이가 2인 부분문자열이 뒤집은 문자열에서 존재하냐?
*/

class Leetcode.이재훈.이재훈.Solution {
    @_optimize(speed)
    func isSubstringPresent(_ s: String) -> Bool {
        let original = ContiguousArray(s)
        var substrings = Set<String>()
        
        for i in 0..<s.count-1 {
            let substring = String([original[i], original[i+1]])
            substrings.insert(substring)
        }
        
        let reversed = ContiguousArray(s.reversed())
        for i in 0..<s.count-1 {
            let substring = String([reversed[i], reversed[i+1]])
            if substrings.contains(substring) {
                return true
            }
        }
        
        return false
    }
}
