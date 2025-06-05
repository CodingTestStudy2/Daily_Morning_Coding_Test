/*
p를 *기준으로 splited함


1. s를 순회, 패턴이 일치하면 pIndex를 증가.
2. pIndex == p.count 라면 true

O(N)


*/

<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    func hasMatch(_ s: String, _ p: String) -> Bool {
        let splitedP: [String.SubSequence] = p.split(separator: "*")
        var pIndex: Int = 0
        var i: Int = 0
        let sArr = Array(s)

        while i < sArr.count && pIndex < splitedP.count {
            guard i+splitedP[pIndex].count <= sArr.count else {
                return false
            }

            let pattern = sArr[i..<i+splitedP[pIndex].count]
            
            if String(pattern) == String(splitedP[pIndex]) {
                i += splitedP[pIndex].count
                pIndex += 1
            } else {
                i += 1
            }
        }
        return pIndex == splitedP.count
    }
}
