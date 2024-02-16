def solve(numbers):
    n = len(numbers)
    dp = [0] * (n + 1)
    max_length = 0

    for k in numbers:
        dp[k] = dp[k - 1] + 1
        max_length = max(max_length, dp[k])

    return n - max_length


num_of_child=input()
child_list=[int(num) for num in input().split(" ")]
print(solve(child_list))