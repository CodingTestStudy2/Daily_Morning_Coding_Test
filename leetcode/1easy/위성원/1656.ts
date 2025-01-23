class OrderedStream {
  stream: string[];

  constructor(n: number) {
    this.stream = new Array(n + 1);
  }

  getChunk(idKey: number, value: string): string[] {
    const chunk = [value];

    for (let i = idKey + 1; i < this.stream.length; i++) {
      const nextValue = this.stream[i];
      if (!nextValue) {
        break;
      }

      chunk.push(nextValue);
    }

    return chunk;
  }

  insert(idKey: number, value: string): string[] {
    this.stream[idKey] = value;

    // 왼쪽에 끊어진게 없는지 확인
    let flag = true;
    let j = idKey - 1;
    while (j > 0) {
      if (!this.stream[j]) {
        flag = false;
        break;
      }
      j--;
    }

    if (flag) {
      return this.getChunk(idKey, value);
    }

    return [];
  }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * var obj = new OrderedStream(n)
 * var param_1 = obj.insert(idKey,value)
 */
