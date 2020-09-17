def sums(nums):
    pre = 0
    for j in range(len(nums)):
        cur = (pre + nums[j])
        yield cur
        pre = cur


f = sums([1, 2, 3, 4])
for i in f:
    print(i)
