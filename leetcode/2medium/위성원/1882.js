/**
 * @param {number[]} servers
 * @param {number[]} tasks
 * @return {number[]}
 */
var assignTasks = function (servers, tasks) {
  const ans = [];
  const serversWithStatus = servers.map((weight, index) => ({
    weight,
    taskEndTime: 0,
    index,
  }));
  let second = 0;

  const getFreeServer = (task) => {
    let minWeight = Infinity;
    let minIndex = -1;
    let secondTaskTime = Infinity;
    let secondMinIndex = 0;
    serversWithStatus.forEach(({ weight, taskEndTime }, index) => {
      const free = second >= taskEndTime;
      if (free && minWeight > weight) {
        minWeight = weight;
        minIndex = index;
      }

      if (secondTaskTime > taskEndTime) {
        secondMinIndex = index;
        secondTaskTime = taskEndTime;
      }
    });

    // there's no free server
    if (minIndex === -1) {
      minIndex = secondMinIndex;
      second = secondTaskTime;
    }

    serversWithStatus[minIndex] = {
      ...serversWithStatus[minIndex],
      taskEndTime: second + task,
    };

    return serversWithStatus[minIndex];
  };

  for (let i = 0; i < tasks.length; i++) {
    const currentTasks = tasks[i];
    const freeServer = getFreeServer(currentTasks);
    ans.push(freeServer.index);
    second++;
  }

  return ans;
};
