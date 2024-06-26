/*
https://school.programmers.co.kr/learn/courses/30/lessons/76502

1. 문제분석
[]{}() 1~1000개 문자열 s -> 조건을 충족하는 왼쪽 시프트 가능개수 리턴 (최대 s.length - 1)
 -> 열고 닫고 + 중첩 가능 + 나열 가능

2. 풀어보기
[](){} length=6 -> 0 [](){} o, 1 ](){}[ x, 2 (){}[] o, 3 ){}[]( x, 4 {}[]() o, 5 }[](){ x -> 3개

3. 슈도코드
stack[] 선언, s를 받아서 -> [({가 나오면 푸시 -> ])}가 나오면 팝 후 정합성 체크 -> 다 통과시 성공
 -> 이걸 length 만큼 반복 -> 최대 1000*1000 O(N^2)

4. 구현코드

5. 풀이회고
시간복잡도 줄이기, 코드 리팩토링
*/
{
  type Opening = "[" | "(" | "{";
  const CLOSING_BY_OPENING: Record<Opening, string> = {
    "[": "]",
    "(": ")",
    "{": "}",
  };

  const solution = (s: string) => {
    let result = 0;

    for (let i = 0; i < s.length; i++) {
      if (isValidated(s.substring(i) + s.substring(0, i))) {
        result++;
      }
    }

    return result;
  };

  const isValidated = (s: string) => {
    const stack: Opening[] = [];

    for (const c of s) {
      if (c in CLOSING_BY_OPENING) {
        stack.push(c as Opening);
      } else {
        const opening = stack.pop()!;
        if (c !== CLOSING_BY_OPENING[opening]) {
          return false;
        }
      }
    }

    return stack.length === 0 ? true : false;
  };

  console.log(solution("[](){}")); // 3
  console.log(solution("}]()[{")); // 2
  console.log(solution("[)(]")); // 0
  console.log(solution("}}}")); // 0
}
