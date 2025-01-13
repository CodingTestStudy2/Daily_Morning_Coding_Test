import Foundation

/// words 접두사 배열을 사용하여 s를 만들 수 있는가?
class Solution {
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
