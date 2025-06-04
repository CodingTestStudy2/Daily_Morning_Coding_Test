import Foundation

class Leetcode.이재훈.이재훈.Solution {

    func imageSmoother(_ img: [[Int]]) -> [[Int]] {
        var answer: [[Int]] = img

        let width = img.first!.count
        let height = img.count
        let dx = [0, 1, 1, 0, -1, -1, -1, 0, 1]
        let dy = [0, 0, 1, 1, 1, 0, -1, -1, -1]

        func smoother(x: Int, y: Int) -> Int {
            var sum = 0
            var count = 0
            
            (0..<9).forEach { i in

                let (newX, newY) = (x+dx[i], y+dy[i])

                guard 0..<width ~= newX && 0..<height ~= newY else {
                    return
                }

                sum += img[newY][newX]
                count += 1

            }

            return sum/count
        }


        for i in 0..<height {
            for j in 0..<width {
                answer[i][j] = smoother(x: j, y: i)
            }
        }

        return answer
    }
}
