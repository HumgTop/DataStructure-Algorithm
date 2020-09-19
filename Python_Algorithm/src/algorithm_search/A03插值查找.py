from typing import *
from src.algorithm_sort import A04希尔排序


def mySearch(arr: List[int], value: int, left: int, right: int) -> int:
    """

    :param arr: arr是已经升序排列的有序数组
    :param value:
    :param left:
    :param right:
    """

    # 递归头：如果left>right说明arr内不存在该值，返回-1
    if left >= right: return -1
    k = (value - arr[left]) / (arr[right] - arr[left])  # 动态系数
    mid = left + int(k * (right - left))  # 查找分割点

    # 递归查找
    if value < arr[mid]:
        return mySearch(arr, value, left, mid - 1)
    elif value > arr[mid]:
        return mySearch(arr, value, mid + 1, right)
    else:
        return mid


if __name__ == '__main__':
    array = [1, 8, 10, 89, 1000, 1234]
    print(mySearch(array, 89, 0, len(array) - 1))
    pass
