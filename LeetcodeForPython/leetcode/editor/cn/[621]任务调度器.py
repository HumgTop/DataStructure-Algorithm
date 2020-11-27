from typing import *

# leetcode submit region begin(Prohibit modification and deletion)
import heapq as h


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        mp = {}
        for task in tasks:
            mp[task] = mp.get(task, 0) + 1

        taskCnt = []
        for val in mp.values():
            h.heappush(taskCnt, -val)

        time = 0
        while taskCnt:
            tempTask = []
            # 一轮任务执行n+1次
            for i in range(n + 1):
                if taskCnt:
                    restTask = -h.heappop(taskCnt)
                    time += 1
                    restTask -= 1  # 任务数-1
                    # 将剩余任务数大于0的进行入列
                    if restTask > 0: h.heappush(tempTask, -restTask)
                # 如果taskCnt为空，且还有剩余任务，CPU进入待命状态，time+=1
                elif tempTask:
                    time += 1
                else:
                    break
            # 更新taskCnt（因为taskCnt中可能还有任务，所以不能令taskCnt=tempTask
            for task in tempTask:
                h.heappush(taskCnt, task)

        return time


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().leastInterval(["A", "A", "A", "B", "B", "B"], 0))
    pass
