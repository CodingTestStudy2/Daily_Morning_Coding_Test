function minGroupsForValidAssignment(balls: number[]): number {
  // 카운트
  const map = new Map<number, number>()

  balls.forEach((ball) => {
    if (map.has(ball)) {
      map.set(ball, map.get(ball) ?? 0 + 1)
    } else {
      map.set(ball, 1)
    }
  })

  let max = -1;
  let min = Infinity;

  for (const [key, value] of map) {
    if (value > max) {
      max = value;
    }

    if (min > value) {
      min = value;
    }
  }

  if (max - min > 1) {
    // value가 큰 순서대로 정렬
    const arr = Array.from(map).sort((a, b) => b[1] - a[1]);
    // 정렬한 뒤 위에서 부터 쪼개기 (Min을 계속 바꾼다)
    let count = 0;
    for (const [key, value] of arr) {
      if (value > min + 1) {
        // 나눌 수 있는 최대 효율 찾기
        // 1) 박스가 더 적다
        let one = Math.ceil(value / (min + 1));
        let two = Math.ceil(value / (min));

        if (one > two) {
          count += two;
          if (min > two) {
            min = two
          }

        } else if (two > one) {
          count += one;
          if (min > one) {
            min = one
          }
        } else if (two === one) {
          if (value % (min + 1) > value % min) {
            count += one;
            if (min > one) {
              min = one
            }
          } else {
            count += two;
            if (min > two) {
              min = two
            }
          }

        }
      } else {
        count++;
      }
    }

    return count
  } else {
    return map.size
  }



  return 0
};