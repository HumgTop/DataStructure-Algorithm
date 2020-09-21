from typing import *


def bubble_sort(arr: List[int]):
    # 共需交换length-1轮
    n = len(arr)
    for i in range(n):
        flag = False
        # 元素arr[0]比较的最后一个元素位置为arr[n-1-i]
        for j in range(n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                flag = True
        if not flag: return


if __name__ == '__main__':
    a = [3, 9, -1, 20, 10]
    bubble_sort(a)
    print(a)
    pass
