<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    func maxProfit(_ prices: [Int]) -> Int {
        var left: Int = prices[0]
        var right: Int = prices[0]
        var maxProfit = 0

        for i in 1..<prices.count {
            
            if left>prices[i] {
                left = prices[i]
                right = prices[i]
            } else {
                right = prices[i]
                maxProfit = max(maxProfit, right-left)
            }

        }

        return maxProfit
    }
}
