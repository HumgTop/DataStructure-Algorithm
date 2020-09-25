from typing import *


# 不使用任何内建的哈希表库设计一个哈希映射
# 
#  具体地说，你的设计应该包含以下的功能 
# 
#  
#  put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。 
#  get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。 
#  remove(key)：如果映射中存在这个键，删除这个数值对。 
#  
# 
#  
# 示例： 
# 
#  MyHashMap hashMap = new MyHashMap();
# hashMap.put(1, 1);          
# hashMap.put(2, 2);         
# hashMap.get(1);            // 返回 1
# hashMap.get(3);            // 返回 -1 (未找到)
# hashMap.put(2, 1);         // 更新已有的值
# hashMap.get(2);            // 返回 1 
# hashMap.remove(2);         // 删除键为2的数据
# hashMap.get(2);            // 返回 -1 (未找到) 
#  
# 
#  
# 注意： 
# 
#  
#  所有的值都在 [0, 1000000]的范围内。 
#  操作的总数目在[1, 10000]范围内。 
#  不要使用内建的哈希库。 
#  
#  Related Topics 设计 哈希表 
#  👍 77 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # 声明一个长度为10的二维列表
        self.res = [-1] * 100_0000

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        self.res[key] = value

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        return self.res[key]

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        self.res[key] = -1


# class MyHashMap:
#
#     def __init__(self):
#         """
#         Initialize your data structure here.
#         """
#         # 声明一个长度为10的二维列表
#         self.res = [[]] * 10
#
#     def put(self, key: int, value: int) -> None:
#         """
#         value will always be non-negative.
#         """
#         dest = self.res[self.hashFun(key)]
#         for i in range(len(dest)):
#             if dest[i][0] == key:
#                 dest[i][1] = value
#                 return
#
#         dest.append([key, value])
#
#     def get(self, key: int) -> int:
#         """
#         Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
#         """
#         dest = self.res[self.hashFun(key)]
#         for each in dest:
#             if each[0] == key: return each[1]
#
#         return -1
#
#     def remove(self, key: int) -> None:
#         """
#         Removes the mapping of the specified value key if this map contains a mapping for the key
#         """
#         dest = self.res[self.hashFun(key)]
#         for i in range(len(dest)):
#             if dest[i][0] == key:
#                 dest.pop(i)
#                 return
#
#     def hashFun(self, key: int) -> int:
#         """
#         :param key: 对key进行散列，返回存储数组的索引
#         """
#         return key % 10


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    m = MyHashMap()
    m.put(1, 1)
    m.put(2, 2)
    print(m.get(1))
    print(m.get(3))
    m.put(2, 1)
    m.get(2)
    m.remove(2)
    m.get(2)
    pass
