var minimumOperations = function (nums, start, goal) {
  const visited = new Set();
  const isValidOperation = (value) => {
    const isVaild = value >= 0 && value <= 1000 && !visited.has(value);
    isVaild && visited.add(value);
    return isVaild;
  };
  let queue = [start];
  let result = 0;

  while (queue.length) {
    const size = queue.length;
    let nextQueue = [];

    result += 1;
    for (let index = 0; index < size; index++) {
      const value = queue.pop();

      for (const num of nums) {
        const add = value + num;
        const minus = value - num;
        const xor = value ^ num;

        if (add === goal || minus === goal || xor === goal) return result;
        isValidOperation(add) && nextQueue.push(add);
        isValidOperation(minus) && nextQueue.push(minus);
        isValidOperation(xor) && nextQueue.push(xor);
      }
    }
    queue = nextQueue;
  }
  return -1;
};
