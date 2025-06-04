// dp[sum]=max(dp[sum],dp[sum−num]+1)
class Leetcode.이재훈.이재훈.Solution {
    func lengthOfLongestSubsequence(_ nums: [Int], _ target: Int) -> Int {
        var dp = Array(repeating: -1, count: target + 1)
        dp[0] = 0

        for num in nums {
            for sum in stride(from: target, through: num, by: -1) {
                if dp[sum - num] != -1 {
                    dp[sum] = max(dp[sum], dp[sum - num] + 1)
                }
            }
        }

        return dp[target]
    }
}

