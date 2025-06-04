class Leetcode.이재훈.이재훈.Solution {
    func minimumAverage(_ nums: [Int]) -> Double {
        
        let sortedNums = nums.sorted()

        var minAverage: Double = Double(Int.max)
        for i in 0..<sortedNums.count/2 {
            let sum = sortedNums[i]+sortedNums[sortedNums.count-1-i]
            let average: Double = Double(sum) / 2
            if minAverage > average {
                minAverage = average
            }
        }

        return minAverage

    }
}
