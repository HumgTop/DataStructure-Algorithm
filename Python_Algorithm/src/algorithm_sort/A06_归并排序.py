from typing import *


def merge_sort(arr: List[int]) -> List[int]:
    length = len(arr)
    mid = length // 2
    if mid < 1:
        return arr

    left = arr[0:mid]
    right = arr[mid:length]

    sorted_left = merge_sort(left)
    sorted_right = merge_sort(right)

    return merge(sorted_left, sorted_right)


def merge(left: List[int], right: List[int]) -> List[int]:
    """
    将left和right中的元素按照升序排列的方式合并到result中
    :param left:
    :param right:
    """
    l_length = len(left)
    r_length = len(right)
    result = []
    l_i = 0
    r_i = 0

    while l_i < l_length and r_i < r_length:
        if left[l_i] < right[r_i]:
            result.append(left[l_i])
            l_i += 1
        else:
            result.append(right[r_i])
            r_i += 1

    if l_i < l_length:
        result += left[l_i:]

    if r_i < r_length:
        result += right[r_i:]

    return result


if __name__ == '__main__':
    a = [8, 4, 5, 7, 1, 3, 6, 2, 222]
    print(merge_sort(a))
    pass
