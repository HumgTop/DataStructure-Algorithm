from typing import *


def greedy(k_map: Dict[str, set], cnc: set) -> List[str]:
    select = []
    while len(cnc) > 0:
        max_key = None  # str类型
        # 遍历所有的电台
        for k, cover in k_map.items():
            real_cover = cover & cnc  # 当前电台实际增加的覆盖城市
            if len(real_cover) > 0 and (max_key is None or len(real_cover) > len(k_map[max_key])):
                max_key = k
        # 一轮遍历后将能实际增加最多覆盖城市的key存入select中
        if max_key is not None:
            select.append(max_key)
            # 完成覆盖的城市从cnc中移除
            cnc -= k_map[max_key]
    return select


if __name__ == '__main__':
    # 创建广播电台字典:key为电台名，value为覆盖地区
    k1_city = {'北京', '上海', '天津'}
    k2_city = {"广州", "北京", "深圳"}
    k3_city = {"成都", "上海", "杭州"}
    k4_city = {"上海", "天津"}
    k5_city = {"杭州", "大连"}
    k_map = {'k1': k1_city, 'k2': k2_city, 'k3': k3_city, 'k4': k4_city, 'k5': k5_city}

    # 需要覆盖的所有城市
    cnc = {"北京", "上海", "天津", "广州", "深圳", "成都", "杭州", "大连"}  # city need cover

    select = greedy(k_map, cnc)
    print(select)
    pass
