<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    func sumIndicesWithKSetBits(_ nums: [Int], _ k: Int) -> Int {
        var answer = 0
        for (offset, element) in nums.enumerated() {
            guard k == offset.nonzeroBitCount else { continue }
            answer += element
        }
        return answer
    }
}
