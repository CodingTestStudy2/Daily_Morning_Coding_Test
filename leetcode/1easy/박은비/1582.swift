<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    func numSpecial(_ mat: [[Int]]) -> Int {
        // [[0,0,0,1],[1,0,0,0],[0,1,1,0],[0,0,0,0]]

        // 행 1차원 배열
        var rowSpecialCount = Array(repeating: 0, count: mat.count)
        // 열 1차원 배열
        var columnSpecialCount = Array(repeating: 0, count: mat[0].count)

        // 등장횟수를 행, 열 1차원 배열에 카운팅
        // rowSpecialCount: [1, 1, 2, 0]
        // columnSpecialCount: [1, 1, 1, 1]
        for i in 0..<mat.count {
            for j in 0..<mat[i].count {
                if mat[i][j] == 1 {
                    rowSpecialCount[i] += 1
                    columnSpecialCount[j] += 1
                }
            }
        }

        // 특별한 위치 찾기
        var result = 0
        for i in 0..<mat.count {
            for j in 0..<mat[0].count {
                // 1 등장위치 && 행 1차원 배열에 1번 등장 && 열 1차원 배열에 1번 등장
                if mat[i][j] == 1 && rowSpecialCount[i] == 1 && columnSpecialCount[j] == 1 {
                    result += 1
                }
            }
        }

        return result
    }
}
