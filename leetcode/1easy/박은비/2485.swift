class Leetcode.이재훈.이재훈.Solution {
    func pivotInteger(_ n: Int) -> Int {
        var leftSum = (1...n).reduce(0, +)
        var rightSum = 0

        for i in stride(from: n, through: 1, by: -1) {
            rightSum += i

            if leftSum == rightSum {
                return i
            }
            leftSum -= i
        }

        return -1
    }
}
