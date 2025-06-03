class Leetcode.이재훈.Solution {
    func sumIndicesWithKSetBits(_ nums: [Int], _ k: Int) -> Int {
        var answer = 0
        for (offset, element) in nums.enumerated() {
            guard k == offset.nonzeroBitCount else { continue }
            answer += element
        }
        return answer
    }
}
