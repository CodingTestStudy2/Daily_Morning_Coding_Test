/*
1 <= s.length == t.length <= 2 * 105
1 <= k <= s.length
s.length로 나누어 떨어진다 k.
st소문자 영어 글자로만 구성됩니다 .
입력은 서로의 애너그램이 되도록 생성됩니다. st
*/

/// Time Limit Exceeded 755 / 771 testcases passed
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
   func isPossibleToRearrange(_ s: String, _ t: String, _ k: Int) -> Bool {
        guard s.count % k == 0 else { return false }
        
        let strLen = s.count / k
        var sArr = Array(s)
        var tArr = Array(t)
        
        var sSubstringsArr = Array<String>()
        
        for i in stride(from: strLen, through: s.count, by: strLen) {
            let substring = String(sArr[i-strLen..<i])
            sSubstringsArr.append(substring)
        }

        var tSubstringsArr = Array<String>()
        for i in stride(from: strLen, through: t.count, by: strLen) {
            let substring = String(tArr[i-strLen..<i])
            if let found = sSubstringsArr.firstIndex(where: { $0 == substring }) {
                sSubstringsArr.remove(at: found)
                continue
            } else {
                return false
            }
        }

        return sSubstringsArr.isEmpty
    }
    
}

