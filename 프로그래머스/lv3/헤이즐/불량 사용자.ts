/*
https://school.programmers.co.kr/learn/courses/30/lessons/64064

1. 문제분석
전체 1~8자 1~8개 user_id[], 블랙 1~8자 1~8개 banned_id[] -> 마스킹(*)에 따른 경우의 수 리턴
 -> 아이디 마스킹(*) -> 문자 1개와 대응, 아이디당 1개 이상 존재
????? 마스킹된 아이디 값을 기준으로 블랙리스트를 거는 건 이상한데?

2. 풀어보기
user_id ['frodo','fradi','crodo','abc123','frodoc'], banned_id ['fr*d*','abc1**']
-> fr*d* ['frodo','fradi'], abc1** ['abc123'] -> 2C1, 1C1 -> 2*1/1*1=2, 1 -> 2가지

3. 슈도코드
banned_id[] 받아서 -> counts[] 만들고 -> 정규식 활용 (시간 터지면 루프로 전환)
 -> n=count, r=1로 조합수 각각 구한 후 -> 결과를 곱해서 리턴

4. 구현코드

5. 풀이회고
제대로 못 풀었음. 해답 보고 복기 해봐야 함.
*/
const solution = (user_ids: string[], banned_ids: string[]) => {
  const count_by_banned_id = new Map<string, number>();
  for (const banned_id of banned_ids) {
    const count = count_by_banned_id.get(banned_id) ?? 0;
    count_by_banned_id.set(banned_id, count + 1);
  }

  const counts: number[] = [];
  let combinations: number = 1;

  for (const [banned_id, r] of count_by_banned_id) {
    const regExp = new RegExp('^' + banned_id.replaceAll('*', '[a-z0-9]') + '$');

    let count = 0;
    for (let i = user_ids.length - 1; i >= 0; i--) {
      if (user_ids[i].match(regExp)) {
        count++;
        user_ids.splice(i, 1);
      }
    }
    counts.push(count);

    if (count > 0) {
      const combination = factorial(count) / (factorial(count - r) * factorial(r));
      combinations *= combination;
    }
  }

  return combinations;
};

const factorial = (n: number): number => {
  return n ? n * factorial(n - 1) : 1;
};

console.log(solution(['frodo', 'fradi', 'crodo', 'abc123', 'frodoc'], ['fr*d*', 'abc1**'])); // 2
console.log(solution(['frodo', 'fradi', 'crodo', 'abc123', 'frodoc'], ['*rodo', '*rodo', '******'])); // 2
console.log(solution(['frodo', 'fradi', 'crodo', 'abc123', 'frodoc'], ['fr*d*', '*rodo', '******', '******'])); // 3
