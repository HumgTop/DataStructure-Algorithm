from typing import *
import itertools


# 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
# 
#  每个 LED 代表一个 0 或 1，最低位在右侧。 
# 
#  
# 
#  例如，上面的二进制手表读取 “3:25”。 
# 
#  给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。 
# 
#  
# 
#  示例： 
# 
#  输入: n = 1
# 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "
# 0:32"] 
# 
#  
# 
#  提示： 
# 
#  
#  输出的顺序没有要求。 
#  小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。 
#  分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。 
#  超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。 
#  
#  Related Topics 位运算 回溯算法 
#  👍 167 👎 0


# leetcode submit region begin(Prohibit modification and deletion)

class Solution:
    def readBinaryWatch(self, num: int) -> List[str]:
        res = []
        hour = [1, 2, 4, 8]
        minute = [1, 2, 4, 8, 16, 32]

        def traceback(rest: int, start: int, status: List[int]):
            """

            :param rest: 剩余可亮灯数
            :param start: 当前灯可选择的起始位置（前面的灯已经被选择过）
            :param status: status[i]=1，表示第i个灯被点亮
            """
            # 如果num==0，说明递归结束，处理结果
            if rest == 0:
                h = sum([i * j for i, j in zip(hour, status[:4])])
                m = sum([i * j for i, j in zip(minute, status[4:])])
                if h > 11 and m > 59:
                    # 选择满足条件的添加到结果集
                    res.append('%d:%02d' % (h, m))
                return

            for i in range(start, 10):
                # 做出选择（点亮led灯）
                status[i] = 1
                traceback(rest - 1, i + 1, status)
                # 撤销选择（更新本层中打开的是第几个led灯）
                status[i] = 0

        traceback(num, 0, [0] * 10)
        return res


# class Solution:
#     def readBinaryWatch(self, num: int) -> List[str]:
#         """
#
#         :param num: 当前亮着的led灯的数量
#         """
#         hour_led = (8, 4, 2, 1)
#         min_led = (32, 16, 8, 4, 2, 1)
#         result = []
#
#         hour_led_max = 4 if num >= 5 else num
#
#         for i in range(hour_led_max + 1):
#             hour_set = set()
#             min_set = set()
#
#             # 小时灯亮了i个，对小时灯进行组合
#             for j in itertools.combinations(hour_led, i):
#                 # 对组合j遍历相加，保留和<=11的数
#                 hour = sum(j)  # 如果j长度为0，则sum求和为0
#                 if hour <= 11: hour_set.add(hour)
#
#             # 分钟灯亮了i个，对分钟灯进行组合
#             for j in itertools.combinations(min_led, num - i):
#                 minute = sum(j)
#                 if minute <= 59: min_set.add(minute)
#
#             # 对hour_set和min_set进行笛卡尔积
#             for hour, minute in itertools.product(hour_set, min_set):
#                 hour = str(hour)
#                 minute = str(minute) if minute >= 10 else '0' + str(minute)
#                 result.append(hour + ':' + minute)
#
#         return result


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    a = 1
    print('%02d' % a)
    pass
