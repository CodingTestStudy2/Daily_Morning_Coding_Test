class Leetcode.이재훈.Solution {
    func generateTheString(_ n: Int) -> String {
        
        let count = n % 2 == 0
        ? 1
        : 0

        var answer = String(repeating: "a", count: count)
        answer += String(repeating: "z", count: n-count)

        return answer

    }
}
