/*
문자열 단어가 주어집니다. 소문자와 대문자로 단어에 모두 나타나면 특수 문자라고 합니다.
*/
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    func numberOfSpecialChars(_ word: String) -> Int {
        let wordSet = Set(Array(word))
        let setCount = wordSet.count

        let lowercasedSet = Set(wordSet.map { $0.lowercased() })
        return setCount - lowercasedSet.count
    }
}
