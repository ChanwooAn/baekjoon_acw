import sys


def find_usable_smallest_lego_brick(bricks: list[int], target_size: int):
    start = 0
    end = len(bricks) - 1

    smallest_lego_brick_size = 0
    biggest_lego_brick_size = 0
    while start < end:
        small_lego = bricks[start]
        big_lego = bricks[end]

        sum_of_two_part = small_lego + big_lego
        if sum_of_two_part == target_size:
            smallest_lego_brick_size = small_lego
            biggest_lego_brick_size = big_lego
            break
        elif sum_of_two_part < target_size:
            start = start + 1
        else:
            end = end - 1

    return smallest_lego_brick_size, biggest_lego_brick_size


def solution():
    x = int(sys.stdin.readline())
    x = x * 10000000

    n = int(sys.stdin.readline())
    lego_bricks = [int(sys.stdin.readline()) for _ in range(n)]
    lego_bricks.sort()
    if len(lego_bricks) < 2:
        print("danger")
        return

    smallest_lego_brick_size, biggest_lego_brick_size = find_usable_smallest_lego_brick(bricks=lego_bricks,
                                                                                        target_size=x)

    if biggest_lego_brick_size + smallest_lego_brick_size >= x:
        print(f"yes {smallest_lego_brick_size} {biggest_lego_brick_size}")
    else:
        print("danger")


while (True):
    try:
        solution()
    except:
        break