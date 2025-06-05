<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    func generateTheString(_ n: Int) -> String {
        
        let count = n % 2 == 0
        ? 1
        : 0

        var answer = String(repeating: "a", count: count)
        answer += String(repeating: "z", count: n-count)

        return answer

    }
}
