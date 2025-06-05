import Foundation

/// words 접두사 배열을 사용하여 s를 만들 수 있는가?
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    func isPrefixString(_ s: String, _ words: [String]) -> Bool {
        
        var string = ""

        for word in words {
            string += word

            if s == string { 
                return true
            }

            if string.count > s.count {
                return false
            }
        }

        return false
    }
}
