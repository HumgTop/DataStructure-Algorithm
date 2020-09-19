from typing import *


def shell_sort(arr: List[int]) -> List[int]:
    length = len(arr)
    gap = length // 2
    while gap > 0:
        # 处理索引从gap到length-1的所有元素（因为前gap个元素视为有序表）
        for i in range(gap, length):
            temp = arr[i]
            insert_index = i - gap  # 定义初始比较位置
            while insert_index >= 0 and temp < arr[insert_index]:
                arr[insert_index + gap] = arr[insert_index]
                insert_index -= gap
            # 此时temp>=arr[insert_index]或者insert_index<0
            arr[insert_index + gap] = temp  # 将temp插入正确的位置
        gap //= 2

    return arr


if __name__ == '__main__':
    array = [8, 9, 1, 7, 2, 3, 5, 4, 6, 0]
    print(shell_sort(array))
    pass
