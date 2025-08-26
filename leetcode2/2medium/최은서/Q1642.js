/**
 * @param {number[]} heights
 * @param {number} bricks
 * @param {number} ladders
 * @return {number}
 */
class MyMinHeap {
  constructor() {
    this.heap = [];
  }
  size() {
    return this.heap.length;
  }
  enqueue(value) {
    this.heap.push(value); //맨 끝에 원소를 넣고
    this.bubbleUp();
  }
  bubbleUp() {
    //현재 맨 끝 원소를 맨 위로 올리는 과정
    let curIdx = this.size() - 1;
    while (curIdx > 0) {
      let parIdx = Math.floor((curIdx - 1) / 2);
      if (this.heap[curIdx] < this.heap[parIdx]) {
        [this.heap[curIdx], this.heap[parIdx]] = [
          this.heap[parIdx],
          this.heap[curIdx],
        ];
        curIdx = parIdx;
      } else {
        break;
      }
    }
  }
  dequeue() {
    if (this.size() === 0) return;
    if (this.size() === 1) return this.heap.pop();
    const root = this.heap[0];
    this.heap[0] = this.heap.pop();
    this.bubbleDown();
    return root;
  }
  bubbleDown() {
    //맨 위 원소가 자기 자리 찾아가는 과정
    let curIdx = 0;
    while (true) {
      const left = curIdx * 2 + 1;
      const right = curIdx * 2 + 2;
      let swap = null;
      if (left < this.size() && this.heap[left] < this.heap[curIdx]) {
        swap = left;
      }
      if (right < this.size() && this.heap[right] < this.heap[curIdx]) {
        if (swap === null) swap = right;
        else if (swap === left && this.heap[right] < this.heap[left]) {
          swap = right;
        }
      }
      if (swap === null) break;
      [this.heap[curIdx], this.heap[swap]] = [
        this.heap[swap],
        this.heap[curIdx],
      ];
      curIdx = swap;
    }
  }
}
//처음에는 언제 사다리를 주고, 언제 벽돌을 줄 지 모호해서 남은 diff가 bricks 절반보다 크면 사다리 주는 방식으로 했지만, 최적을 보장하지 않는다 (나중에 더 큰 diff가 나올 수 있기 때문)
//우선순위 큐를 이용해 (최소힙) diff를 넣고, 사다리가 부족할 때마다 가장 작은 diff를 벽돌로 채워나감
var furthestBuilding = function (heights, bricks, ladders) {
  const pq = new MyMinHeap();
  for (let i = 0; i < heights.length - 1; i++) {
    const diff = heights[i + 1] - heights[i];
    if (diff > 0) {
      //사다리 혹은 벽돌이 필요한 경우
      pq.enqueue(diff);
      if (pq.size() > ladders) {
        //사다리로만 커버 못 칠 때
        bricks -= pq.dequeue();
        //벽돌을 사용
        if (bricks < 0) return i; //벽돌이 모자르면 더 이상 이동 불가
      }
    }
  }
  return heights.length - 1; //끝까지 이동했으면 전체 이동한 횟수 반환
};
