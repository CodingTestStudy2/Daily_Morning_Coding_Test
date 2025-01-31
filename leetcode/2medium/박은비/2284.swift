class Solution {
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
