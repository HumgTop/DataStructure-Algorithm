from typing import *


def get_left_child(i: int) -> int:
    return 2 * i + 1


def heapify(arr: List[int], cur: int, length: int):
    temp = arr[cur]
    while get_left_child(cur) < length:
        child_index = get_left_child(cur)
        if child_index + 1 < length and arr[child_index + 1] > arr[child_index]: child_index += 1
        if temp < arr[child_index]:
            arr[cur] = arr[child_index]
        else:
            break
        cur = child_index
    arr[cur] = temp


def heapsort(arr: List[int]):
    # 将arr调整为大顶堆。非叶节点从下往上调整
    n = len(arr)
    for i in range(n // 2 - 1, -1, -1):  # arr[0]也需要调整，所以stop为-1（取到0）
        heapify(arr, i, n)

    # 交换堆顶堆尾元素，重新调整堆
    for i in range(n - 1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0]
        heapify(arr, 0, i)


if __name__ == '__main__':
    arr = [4, 6, 8, 5, 9]
    heapsort(arr)
    print(arr)
    pass
