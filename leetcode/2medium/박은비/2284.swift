<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    func largestWordCount(_ messages: [String], _ senders: [String]) -> String {
        var senderWordCount: [String: Int] = [:]

        for (offset, element) in messages.enumerated() {
            let splited = element.split(separator: " ")
            senderWordCount[senders[offset], default: 0] += splited.count
        }

        return senderWordCount.sorted { lhs, rhs in
            if lhs.value == rhs.value {
                return lhs.key > rhs.key
            }
            return lhs.value > rhs.value
        }
        .first!
        .key
    }
}
