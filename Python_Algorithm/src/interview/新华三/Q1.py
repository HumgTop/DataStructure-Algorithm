from typing import *

import re


class Solution:
    def WeekHelp(self, pcIPStr):
        res = []
        week = ['Mon', 'Tues', 'Wednes', 'Thurs', 'Fri', 'Satur', 'Sun']
        for s in week:
            if s.lower().find(pcIPStr.lower()) != -1: res.append(s)

        if len(res) == 0:
            return 'NotFound'
        elif len(res) == 1:
            return res[0]
        else:
            return 'Multi'


if __name__ == '__main__':
    print(Solution().WeekHelp('wed'))
    pass
