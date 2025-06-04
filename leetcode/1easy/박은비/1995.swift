/*
4 <= nums.length <= 50
1 <= nums[i] <= 100
*/
class Leetcode.이재훈.이재훈.Solution {
    func countQuadruplets(_ nums: [Int]) -> Int {
        let n = nums.count
        var count = 0

        for a in 0..<n {
            for b in (a+1)..<n {
                for c in (b+1)..<n {
                    for d in (c+1)..<n {
                        if nums[a] + nums[b] + nums[c] == nums[d] {
                            count += 1
                        }
                    }
                }
            }
        }

        return count
    }
}
