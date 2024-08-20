import java.util.*;
class Solution {
    static List<Integer> numbers = new ArrayList<>();
    static List<Character> opers = new ArrayList<>();

    public long solution(String expression) {
        long answer = 0;
        // 3가지의 연산문자
        // 전달받은 수식에 포함된 연산자의 우선순위를 자유롭게 재정의
        // 수식의 결과값의 절댓값이 최대가 되게끔 정의해야함
        // 같은 순위의 연산자는 없음

        // 1. 수식 파싱
        parseExpression(expression);

        // 2. 연산자 우선순위 별 brute force
        // 중복 없는 연산자의 수를 찾는다.

        Set<Character> distOpers = new HashSet<Character>(opers);
        List<Character> distOpersList = new ArrayList<>(distOpers);


        List<List<Character>> permutedOpers = new ArrayList<>();
        generatePermutations(distOpersList, 0, permutedOpers);

        // 각 우선순위에 따른 계산 결과 확인
        for (List<Character> priority : permutedOpers) {
            long result = calculate(priority);
            answer = Math.max(answer, Math.abs(result));
        }

        return answer;
    }
    // input String -> output void
    private void parseExpression(String expression){
        int intValue = 0;
        for (char x : expression.toCharArray()) {
            if (Character.isDigit(x)) {
                intValue = (intValue * 10) + (x - '0');
                continue;
            }
            // 연산자일 경우,
            // 1) intValue 배열에 추가, 초기화
            numbers.add(intValue);
            intValue = 0;

            // 2) 연산자 배열에 추가
            opers.add(x);
        }
        // 마지막 숫자 추가
        numbers.add(intValue);

    }
    // 순열 생성
    // 순서를 바꿔
    private void generatePermutations(List<Character> opers, int depth, List<List<Character>> result) {
        if (depth == opers.size()) {
            result.add(new ArrayList<>(opers));
            return;
        }

        for (int i = depth; i < opers.size(); i++) {
            Collections.swap(opers, depth, i);
            generatePermutations(opers, depth + 1, result);
            Collections.swap(opers, depth, i); // 원래대로 복원
        }
    }
    // 주어진 우선순위에 따라 수식을 계산
    private long calculate(List<Character> priority) {
        // numbers와 opers를 복사하여 사용
        List<Long> nums = new ArrayList<>();
        for (int num : numbers) {
            nums.add((long) num);
        }
        List<Character> ops = new ArrayList<>(opers);

        for (char op : priority) {
            for (int i = 0; i < ops.size(); i++) {
                if (ops.get(i) == op) {
                    long num1 = nums.get(i);
                    long num2 = nums.get(i + 1);
                    long result = applyOperation(num1, num2, op);

                    // 결과를 리스트에 갱신
                    nums.set(i, result);
                    nums.remove(i + 1);
                    ops.remove(i);
                    i--; // 인덱스 조정
                }
            }
        }

        return nums.get(0); // 최종 계산 결과 반환
    }

    private long applyOperation(long num1, long num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }


}