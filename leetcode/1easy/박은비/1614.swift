class Solution {
    func maxDepth(_ s: String) -> Int {
/*
(1+(2*3)+((8)/4))+1

( -> depth를 증가
) -> depth를 감소


*/
        var maxCount: Int = 0
        var depth: Int = 0

        for c in s {
            switch c {
                case "(":
                    depth += 1
                    maxCount = max(maxCount, depth)
                case ")":
                    depth -= 1
                default:
                    continue
            }
        }


        return maxCount
    }
}
