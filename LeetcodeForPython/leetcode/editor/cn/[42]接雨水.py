from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def trap(self, height: List[int]) -> int:
        stack = []
        res = 0
        for i, h in enumerate(height):
            while stack and h > height[stack[-1]]:
                # 出栈底部高度索引
                bottom = stack.pop()
                if not stack: break

                leftHid = stack[-1] # 左侧高度索引
                rightHid = i    # 右侧高度索引
                curH = min(height[leftHid], height[rightHid]) - height[bottom]  # 实际接水区域高度（减去底部高度）
                res += (rightHid - leftHid - 1) * curH

            stack.append(i)

        return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
